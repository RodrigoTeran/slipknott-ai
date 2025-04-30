import csv
import os
from abc import ABC, abstractmethod
from termcolor import colored
from typing import Optional
from utlis import dict_from_my_report


class Algorithm(ABC):
    def __init__(self, tool: str, version: int, quiet: bool) -> None:
        super().__init__()
        # name of tool
        self.TOOL: str = tool
        # path to dataset of pairs
        self.DATASET_DIR: str = os.path.join('versions', f'version_{version}')
        # number of pairs
        self.COUNT: int = len(os.listdir(self.DATASET_DIR))
        # generated folder for tool reports
        self.GEN_DIR: str = os.path.join('generated', tool, f'version_{version}')
        # directory for tool reports in uniform format
        self.REPORT_DIR: str = os.path.join('reports', tool, f'version_{version}')
        # csv file with tool report (unifom format)
        self.REPORT_CSV: str = os.path.join(self.REPORT_DIR, 'report.csv')
        # report of time execution
        self.REPORT_TIME: str = os.path.join(self.REPORT_DIR, 'time.csv')
        # flag to print a progress
        self.SHOW_PROGRESS: bool = quiet
        # path to executable file (tool)
        self.EXE_PATH: Optional[str] = None

    @abstractmethod
    def _run_on_pair(self, pair_dir_path: str) -> None:
        raise NotImplementedError()

    @abstractmethod
    def _get_pair_similarity(self, pair: str) -> float:
        raise NotImplementedError()

    def run(self) -> None:
        os.makedirs(self.REPORT_DIR, exist_ok=True)
        for i, pair in enumerate(os.listdir(self.DATASET_DIR)):
            if self.SHOW_PROGRESS:
                print(f'[{i + 1}/{self.COUNT}] Processing {pair}')

            self._run_on_pair(pair)

    def generate_report(self) -> None:
        my_report = dict_from_my_report()

        if not os.path.exists(self.REPORT_DIR):
            os.makedirs(self.REPORT_DIR, exist_ok=True)

        with open(self.REPORT_CSV, 'w') as report:
            writer = csv.writer(report, delimiter=',')
            writer.writerow(['sub1', 'sub2', 'problem', 'tool-sim', 'gold-verd'])

            for pair in os.listdir(self.GEN_DIR):
                f1, f2 = sorted(pair.split('_'))
                problem, gold_verd = my_report[f'{f1}_{f2}']
                tool_sim = self._get_pair_similarity(pair)
                writer.writerow(
                    [f1, f2, problem, tool_sim, gold_verd])

        print(colored('[OK] Report generated', 'green'))
        print(f'You can find a final report in {self.REPORT_DIR}')
