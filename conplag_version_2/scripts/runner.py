import argparse
from termcolor import colored
from typing import Optional

from bplag import BPlagAlgortihm
from dolos import DolosAlgorithm
from jplag import JPlagAlgorithm
from moss import MossAlgorithm
from sherlock import SherlockAlgorithm
from sim import SimAlgorithm


class Runner:
    def __init__(self, mode: str, version: int, tool: str) -> None:
        self.mode = mode
        self.version = version

        if tool == 'moss':
            self.algorithm = MossAlgorithm(self.version, quiet=True)
        if tool == 'sim':
            self.algorithm = SimAlgorithm(self.version, quiet=True)
        elif tool == 'sherlock':
            self.algorithm = SherlockAlgorithm(self.version, quiet=True)
        elif tool == 'bplag':
            self.algorithm = BPlagAlgortihm(self.version, quiet=True)
        elif tool == 'jplag':
            self.algorithm = JPlagAlgorithm(self.version, quiet=True)
        elif tool == 'dolos':
            self.algorithm = DolosAlgorithm(self.version, quiet=True)

    def run(self) -> None:
        if self.algorithm is None:
            print('algo is none')
            return

        if 'r' in self.mode:
            self.algorithm.run()

        if 'g' in self.mode:
            self.algorithm.generate_report()


def process_error(parser: argparse.ArgumentParser) -> None:
    err_msg = 'Error has occured. The way to use this script is given below:'
    print(colored(err_msg, 'red'))
    parser.print_help()
    exit(1)


if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        description='Script for running tools on the dataset')

    mode_help = '\'r\' for run tool, \'g\' for generate uniform report'
    parser.add_argument('--mode', metavar='mode',
                        type=str, nargs=1, help=mode_help)

    tool_help = 'tool name to run: sherlock, sim, moss, dolos, jplag, bplag'
    parser.add_argument('--tool', metavar='tool',
                        type=str, nargs=1, help=tool_help)

    version_help = 'dataset version: \'1\' means \'row\' version \
         and \'2\' means \'template free\' version'
    parser.add_argument('--version', metavar='version',
                        type=int, nargs=1, help=version_help)

    args = parser.parse_args()

    version: Optional[int] = None
    mode: Optional[str] = None
    tool: Optional[str] = None

    if args.version is None:
        process_error(parser)
    else:
        version = args.version[0]
        if version not in [1, 2]:
            process_error(parser)

    if args.mode is None:
        process_error(parser)
    else:
        mode = args.mode[0]
        if mode not in ['r', 'g', 'rg']:
            process_error(parser)

    if args.tool is None:
        process_error(parser)
    else:
        tool = args.tool[0]
        if tool not in ['sherlock', 'sim', 'moss', 'dolos', 'jplag', 'bplag']:
            process_error(parser)

    if mode is None or version is None or tool is None:
        process_error(parser)
        exit(1)

    runner = Runner(mode, version, tool)
    runner.run()
