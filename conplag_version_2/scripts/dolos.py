import os

from algorithm import Algorithm


class DolosAlgorithm(Algorithm):
    def __init__(self, version: int, quiet: bool) -> None:
        Algorithm.__init__(self, 'dolos', version, quiet)

        self.EXE_PATH: str = 'dolos'

        # k-value for k-gram
        self.key_k: int = 25
        # window size
        self.key_w: int = 30

        if not os.path.exists(self.GEN_DIR):
            os.makedirs(self.GEN_DIR)

    def _run_on_pair(self, pair: str) -> None:
        pair_dir = os.path.join(self.DATASET_DIR, pair)
        pair_report = os.path.join(self.GEN_DIR, pair)
        cmd = f'{self.EXE_PATH} -f csv -k {self.key_k} -w {self.key_w} \
                -l java -o {pair_report} {pair_dir}/*.java'
        os.system(cmd)

    def _get_pair_similarity(self, pair: str) -> float:
        with open(os.path.join(self.GEN_DIR, pair, 'pairs.csv')) as report:
            lines = report.readlines()

            # some errors
            if len(lines) < 2:
                return 0

            content = lines[1]
            sim = 100 * (float(content.split(',')[5]))
            return round(sim, 1)
