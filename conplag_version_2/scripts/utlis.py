import csv
import os
import re
from termcolor import colored
from typing import Optional, Tuple


def findOccurrences(s: str, ch: str) -> list[int]:
    return [i for i, letter in enumerate(s) if letter == ch]


def extractNumber(text: str, pos: int) -> int:
    number = ""
    spaceCnt = 0
    for sym in reversed(text[:pos]):
        spaceCnt += sym == " "
        if sym == "(" or (sym == " " and spaceCnt == 2):
            break
        number += sym

    number = number[::-1]

    return int(number)


def get_bplag_subset(version: int) -> set[str]:
    bplag_subset = set()
    with open(os.path.join('reports', 'bplag', f'version_{version}', 'report.csv'), 'r') as bplag_report:
        reader = csv.reader(bplag_report, delimiter=',')
        for row in reader:
            s1 = row[0]
            s2 = row[1]
            if s1 == 'sub1':
                continue
            bplag_subset.add(f'{s1}_{s2}')

    return bplag_subset


def dict_from_my_report() -> dict[str, Tuple[str, int]]:
    """
    returns the `labels.csv` represented as dict:
    '{sub1}_{sub2} -> (contest, problem, verdict)
    """

    d = {}
    with open(os.path.join('versions', 'labels.csv')) as report:
        reader = csv.reader(report, delimiter=',')
        for row in reader:
            s1, s2, problem, v = row
            if s1 == 'sub1':
                continue

            if '?' in v:
                continue

            s1_s2 = '_'.join(sorted([s1, s2]))
            d[s1_s2] = (problem, int(v == '1'))

    return d


def url_comparsion_for_pair(contest: str, problem: str, sub1: str, sub2: str) -> Optional[str]:
    dir = os.path.join('jplag_result', contest, problem, 'java')
    pattern = re.compile(r"match[0-9]+\.html")
    for file in os.listdir(dir):
        if not re.match(pattern, file):
            continue

        with open(os.path.join(dir, file), "r") as match_file:
            content = match_file.read()
            if (sub1 in content) and (sub2 in content):
                return os.path.join(dir, file)

    return None


def get_test_pairs() -> list[str]:
    with open(os.path.join('versions', 'test_pairs.csv'), 'r') as f:
        return [line.strip() for line in f.readlines()]


def get_train_pairs() -> list[str]:
    with open(os.path.join('versions', 'train_pairs.csv'), 'r') as f:
        return [line.strip() for line in f.readlines()]


def print_progressbar(progress: float) -> None:
    p = int(progress)
    r = 100 - p
    bar = '[' + '#' * p + '.' * r + f']'
    print(colored(bar, 'green') + f' {p}%', end='\r', flush=True)
