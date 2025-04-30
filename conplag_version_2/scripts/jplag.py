import os

from algorithm import Algorithm


class JPlagAlgorithm(Algorithm):
    def __init__(self, version: int, quiet: bool) -> None:
        Algorithm.__init__(self, 'jplag', version, quiet)

        self.EXE_PATH: str = os.path.join(
            'resources', 'jplag', 'jplag-2.12.1-SNAPSHOT-jar-with-dependencies.jar')

        # minimal length of tokens match
        self.key_t: int = 11

        if not os.path.exists(self.GEN_DIR):
            os.makedirs(self.GEN_DIR)

    def _run_on_pair(self, pair: str) -> None:
        pair_dir = os.path.join(self.DATASET_DIR, pair)
        pair_report = os.path.join(self.GEN_DIR, pair)
        cmd = f'java -jar {self.EXE_PATH} -vq -l java17 -m 0% \
                 -t {self.key_t} -r {pair_report} {pair_dir}'
        os.system(cmd)

    def _get_pair_similarity(self, pair: str) -> float:
        pair_report = os.path.join(self.GEN_DIR, pair, 'matches_max.csv')
        with open(pair_report, 'r') as report_file:
            content = report_file.read().strip()

        # jplag failed on this submissions
        if not content:
            return 0.0

        return round(float(content.split(';')[-2]), 1)
