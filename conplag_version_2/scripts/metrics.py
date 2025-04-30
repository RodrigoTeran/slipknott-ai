import argparse
import csv
import os
import random
from termcolor import colored
from typing import Tuple

from utlis import (dict_from_my_report,
                   get_test_pairs,
                   get_train_pairs,
                   print_progressbar)


GOLD_LABELS: dict[str, Tuple[str, int]] = dict()
TOOLS_SIMILARITY: dict[str, dict[str, float]] = dict()


def init_tools_similarities(tools: list[str], version: int) -> dict[str, dict[str, float]]:
    d = dict()

    for tool in tools:
        d[tool] = dict()

        report_dir = os.path.join(
            'reports', tool, f'version_{version}')
        with open(os.path.join(report_dir, 'report.csv')) as report:
            reader = csv.reader(report, delimiter=',')
            for row in reader:
                s1, s2, _, sim, _ = row
                if s1 == 'sub1':
                    continue

                s1_s2 = '_'.join(sorted([s1, s2]))
                d[tool][s1_s2] = float(sim)
    return d


def calculate_metric(cm: dict[str, int], metric: str) -> float:
    def recall(d: dict[str, int]) -> float:
        return d['tp'] / (d['tp'] + d['fn'])

    def precision(d: dict[str, int]) -> float:
        if d['tp'] == 0:
            return 0
        return d['tp'] / (d['tp'] + d['fp'])

    def f_1(d: dict[str, int]) -> float:
        r = recall(d)
        p = precision(d)
        return 2 * (p * r) / (p + r)

    def f_b(d: dict[str, int]) -> float:
        r = recall(d)
        p = precision(d)
        beta = 1.5
        return (1 + beta ** 2) * (p * r) / (beta ** 2 * p + r)

    return locals()[metric](cm)


def tool_results_on_dataset(tool: str, threshold: int, dataset: list[str], metric: str) -> float:
    if TOOLS_SIMILARITY is None:
        raise RuntimeError('Tools Similarity is None')

    tp, tn, fp, fn = 0, 0, 0, 0

    for s1_s2 in dataset:
        _, gold_verdict = GOLD_LABELS[s1_s2]
        tool_verdict = int(
            float(TOOLS_SIMILARITY[tool].get(s1_s2, 0)) >= threshold)

        tp += gold_verdict == 1 and tool_verdict == 1
        tn += gold_verdict == 0 and tool_verdict == 0
        fp += gold_verdict == 0 and tool_verdict == 1
        fn += gold_verdict == 1 and tool_verdict == 0

    cm = {'tp': tp, 'tn': tn, 'fp': fp, 'fn': fn}
    return calculate_metric(cm, metric)


class ThresholdTuner:
    def __init__(self, tools: list[str], dataset: list[str]) -> None:
        self.tools = tools
        self.dataset = dataset

    def run(self) -> dict[str, float]:
        optimal_thresholds = {}

        for tool in self.tools:
            tool_results = []

            for threshold in range(0, 101):
                result = tool_results_on_dataset(
                    tool, threshold, self.dataset, 'f_b')
                tool_results.append((result, threshold))

            tool_results.sort(reverse=True)
            metric_value, t_opt = tool_results[0]
            metric_value = round(metric_value, 3)
            optimal_thresholds[tool] = t_opt

            print(f'Tuned threshold for {tool}: ', end='')
            print(f'threshold = {t_opt}, F-beta = {metric_value}')

        return optimal_thresholds


class Bootstrap:
    CL = 0.95  # confidence level
    ITERATIONS = 10000  # number of bootstrap iterations

    def __init__(self, tools, dataset, optimal_thresholds, metrics) -> None:
        self.tools = tools
        self.dataset = dataset
        self.optimal_thresholds = optimal_thresholds
        self.metrics = metrics

    @staticmethod
    def random_subsample(xs: list[str], subsample_size: int) -> list[str]:
        subsample = []
        for _ in range(subsample_size):
            idx = random.randint(0, len(xs) - 1)
            subsample.append(xs[idx])
        return subsample

    def run(self):
        report = ''
        sample_size = len(self.dataset)
        results = dict([(metric, dict([(tool, []) for tool in self.tools]))
                        for metric in self.metrics])

        for i in range(Bootstrap.ITERATIONS):
            print_progressbar(100 * ((i + 1) / Bootstrap.ITERATIONS))

            subsample = Bootstrap.random_subsample(self.dataset, sample_size)
            for metric in self.metrics:
                for tool in self.tools:
                    threshold = self.optimal_thresholds[tool]
                    mertic_value = tool_results_on_dataset(
                        tool, threshold, subsample, metric)
                    results[metric][tool].append(mertic_value)
        print()

        for metric in self.metrics:
            for tool in self.tools:
                results[metric][tool].sort()

        left_idx = int(((1 - Bootstrap.CL) / 2) * self.ITERATIONS)
        right_idx = int(self.ITERATIONS - left_idx)

        for metric in self.metrics:
            report += '------------------\n'
            report += f'Metric: {metric}\n'
            for tool in self.tools:
                lower = round(results[metric][tool][left_idx], 3)
                upper = round(results[metric][tool][right_idx], 3)
                value = round((lower + upper) / 2.0, 3)
                delta = round(value - lower, 3)
                report += f'* {tool}: {value} (±{delta}) | ({lower}, {upper})\n'

        return report


def process_error(parser: argparse.ArgumentParser) -> None:
    err_msg = 'Error has occured. The way to use this script is given below:'
    print(colored(err_msg, 'red'))
    parser.print_help()


if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        description='Script for calculating metrics about given tool')

    tool_help = '''
    Tools for which you need to calculate the metric.
    You can omit this flag, then the calculating will be done for all tools.
    '''
    parser.add_argument('--tool', metavar='tool',
                        type=str, nargs='+', help=tool_help)

    version_help = 'dataset version: \'1\' means \'row\' version \
         and \'2\' means \'template free\' version'
    parser.add_argument('--version', metavar='version',
                        type=int, nargs=1, help=version_help)

    metrics_help = '''
    Metrics by which to compare instruments: precision, recall, f_1 and f_b.
    You can omit this flag, then the comparison will be done by each metric.
    '''
    parser.add_argument('--metric', metavar='metric',
                        type=str, nargs='+', help=metrics_help)

    args = parser.parse_args()

    if args.tool is None:
        tools = ['sherlock', 'sim', 'moss', 'dolos', 'jplag', 'bplag']
    else:
        tools = args.tool

    if args.version is None:
        process_error(parser)
        exit(1)
    else:
        version = args.version[0]

    if args.metric is None:
        metrics = ['recall', 'precision', 'f_1', 'f_b']
    else:
        metrics = args.metric

    test_dataset = get_test_pairs()
    train_dataset = get_train_pairs()

    GOLD_LABELS = dict_from_my_report()
    TOOLS_SIMILARITY = init_tools_similarities(tools, version)

    optimal_thresholds = ThresholdTuner(tools, train_dataset).run()
    report = Bootstrap(tools, test_dataset, optimal_thresholds, metrics).run()

    print(report)
