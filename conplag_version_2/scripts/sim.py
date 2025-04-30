import os

from algorithm import Algorithm
from utlis import findOccurrences, extractNumber


class SimAlgorithm(Algorithm):
    def __init__(self, version: int, quiet: bool) -> None:
        Algorithm.__init__(self, 'sim', version, quiet)

        self.EXE_PATH: str = os.path.join('resources', 'sim', 'sim_java')
        # `r` parameter for SIM
        self.key_r: int = 21

        if not os.path.exists(self.GEN_DIR):
            os.makedirs(self.GEN_DIR)

    def _run_on_pair(self, pair: str) -> None:
        f1, f2 = pair.split('_')
        file1 = os.path.join(self.DATASET_DIR, pair, f'{f1}.java')
        file2 = os.path.join(self.DATASET_DIR, pair, f'{f2}.java')

        gen_pair_dir = os.path.join(self.GEN_DIR, pair)
        os.makedirs(gen_pair_dir, exist_ok=True)

        pair_report1 = os.path.join(gen_pair_dir, f'{f1}_{f2}.txt')
        pair_report2 = os.path.join(gen_pair_dir, f'{f2}_{f1}.txt')

        cmd1 = f'{self.EXE_PATH} -s -r{self.key_r} -p -o {pair_report1} {file1} {file2}'
        cmd2 = f'{self.EXE_PATH} -s -r{self.key_r} -p -o {pair_report2} {file2} {file1}'

        os.system(cmd1)
        os.system(cmd2)

    def _get_pair_similarity(self, pair: str) -> float:
        def get_percent_number(file):
            with open(file, 'r') as pair_report:
                text = pair_report.read()
            # occs is empty <-> file1, file2 have no same tokens
            occs = findOccurrences(text, "%")
            return float(extractNumber(text, occs[0])) if occs else 0.0

        gen_pair_dir = os.path.join(self.GEN_DIR, pair)
        f1, f2 = pair.split('_')
        sim1 = get_percent_number(os.path.join(gen_pair_dir, f'{f1}_{f2}.txt'))
        sim2 = get_percent_number(os.path.join(gen_pair_dir, f'{f2}_{f1}.txt'))

        return max(sim1, sim2)
