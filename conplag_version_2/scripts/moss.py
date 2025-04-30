import os

import mosspy

from algorithm import Algorithm
from utlis import findOccurrences, extractNumber


class MossAlgorithm(Algorithm):
    def __init__(self, version: int, quiet: bool) -> None:
        Algorithm.__init__(self, 'moss', version, quiet)

        self.USERID: int = 803628588

    def _run_on_pair(self, pair: str) -> None:
        # this pair was already processed
        if os.path.exists(os.path.join(self.GEN_DIR, pair)):
            return

        path_to_pair = os.path.join(self.DATASET_DIR, pair)

        m = mosspy.Moss(self.USERID, 'java')

        m.addFilesByWildcard(f'{path_to_pair}/*.java')
        url = m.send(lambda file_path, display_name: print(
            '*', end='', flush=True))

        # m.saveWebPage(url, os.path.join(self.GEN_HTML, f'{subs_dir}.html'))
        if not os.path.exists(os.path.join(self.GEN_DIR, pair)):
            os.makedirs(os.path.join(self.GEN_DIR, pair))

        mosspy.download_report(
            url,
            os.path.join(self.GEN_DIR, pair),
            connections=4,
            log_level=10,
            on_read=lambda url: print('*', end='', flush=True),
        )

    def _get_pair_similarity(self, pair: str) -> float:
        moss_sim = 0
     
        with open(os.path.join(self.GEN_DIR, pair, 'index.html'), 'r') as html_report:
            text = html_report.read()
            exist_mathcing = '%' in text

            if exist_mathcing:
                i1, i2 = findOccurrences(text, '%')
                sim1 = extractNumber(text, i1)
                sim2 = extractNumber(text, i2)
                moss_sim = max(sim1, sim2)
        
        return moss_sim