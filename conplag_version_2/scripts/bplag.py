import os

from algorithm import Algorithm


class BPlagAlgortihm(Algorithm):
    def __init__(self, version: int, quiet: bool) -> None:
        Algorithm.__init__(self, 'bplag', version, quiet)
        self.DATASET_DIR: str = os.path.join('versions', f'bplag_version_{version}')
        self.COUNT: int = len(os.listdir(self.DATASET_DIR))
        self.EXE_PATH: str = os.path.join('resources', 'bplag', 'BPlag-0.1.jar')

        gen_dir = os.path.join('generated', 'bplag', f'version_{version}')
        self.GEN_DIR: str = os.path.join(gen_dir, 'result')
        os.makedirs(self.GEN_DIR, exist_ok=True)
        self.GEN_TRACE: str = os.path.join(gen_dir, 'trace')
        os.makedirs(self.GEN_TRACE, exist_ok=True)
        self.GEN_GRAPH: str = os.path.join(gen_dir, 'graph')
        os.makedirs(self.GEN_GRAPH, exist_ok=True)
        self.VERSION: int = version

    def _generate_trace(self, pair: str) -> None:
        config_path = os.path.join(self.DATASET_DIR, pair, 'config.json')
        gen_trace = os.path.join(self.GEN_TRACE, pair)

        if os.path.exists(gen_trace):
            return

        cmd = f'java -cp {self.EXE_PATH} bplag.TraceGenerator {config_path}'
        os.system(cmd)

    def _process_graph(self, pair: str) -> None:
        input_trace = os.path.join(self.GEN_TRACE, pair)
        output_graph = os.path.join(self.GEN_GRAPH, pair)

        # some error was during trace generation for this pair
        if len(os.listdir(input_trace)) != 2:
            return

        if os.path.exists(output_graph):
            return

        cmd = f'java -cp {self.EXE_PATH} bplag.GraphProcessor {input_trace} {output_graph}'
        os.system(cmd)

    def _compare_graphs(self, pair: str) -> None:
        input_graph = os.path.join(self.GEN_GRAPH, pair)

        # some error was during trace generation for this pair
        if not os.path.exists(input_graph):
            return

        report_dir = os.path.join(self.GEN_DIR, pair)
        result_file = os.path.join(report_dir, f'{pair}.txt')

        if os.path.exists(result_file):
            return

        os.makedirs(report_dir, exist_ok=True)
        cmd = f'java -cp {self.EXE_PATH} bplag.GraphComparator {input_graph} >{result_file}'
        os.system(cmd)

    def _run_on_pair(self, pair: str) -> None:
        self._generate_trace(pair)
        self._process_graph(pair)
        self._compare_graphs(pair)

    def _get_pair_similarity(self, pair: str) -> float:
        with open(os.path.join(self.GEN_DIR, pair, f'{pair}.txt'), "r") as file:
            content = file.read().split()
            if not content:
                return 0.0

            sims = set([float(content[i]) * 100
                        for i in range(2, len(content), 3)])

            return round(max(sims), 1)
