import os

from algorithm import Algorithm


class SherlockAlgorithm(Algorithm):
    def __init__(self, version: int, quiet: bool) -> None:
        Algorithm.__init__(self, 'sherlock', version, quiet)

        self.EXE_PATH: str = os.path.join('resources', 'sherlock', 'sherlock')

        # zerobits
        self.key_z: int = 1
        # number of words
        self.key_n: int = 3

    def _run_on_pair(self, pair: str) -> None:
        path_to_pair = os.path.join(self.DATASET_DIR, pair)
        gen_pair_dir = os.path.join(self.GEN_DIR, pair)
        os.makedirs(gen_pair_dir, exist_ok=True)
        gen_pair_report = os.path.join(gen_pair_dir, f'{pair}.csv')
        cmd = f'{self.EXE_PATH} -z {self.key_z} -n {self.key_n} \
                                -e java {path_to_pair} >{gen_pair_report}'
        os.system(cmd)

    def _get_pair_similarity(self, pair: str) -> float:
        pair_report_path = os.path.join(self.GEN_DIR, pair, f'{pair}.csv')
        with open(pair_report_path, 'r') as f:
            content = f.read()

        if content is None or content == '':
            return 0.0

        return float(content.split(';')[-1].replace('%', ''))
