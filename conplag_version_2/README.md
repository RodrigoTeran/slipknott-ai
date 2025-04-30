# The Dataset of Programming Contest Plagiarism in Java


The current edition of the dataset contains **911** pairs (**251** plagiarized and **660** non-plagiarized) of real contest submissions that can be useful for testing source code plagiarism detection tools. 


## Repository structure

* [versions](./versions) contains the two versions of the dataset --- raw and template-free, see below for details.

* [resources](./resources) contains some of the tools we used in our research that can be run on the dataset.

* [scripts](./scripts) contains scripts for running the tools and providing statistics.

* [reports](./reports) will appear after running the tools on the data, and will contain uniform csv-reports for each tool for each version of the dataset.


## Dataset versions

1. _Raw_. Each program is saved in its original form.
2. _Template-free_. Most template code has been manually removed from each program.

Also, the files [`train_pairs.csv`](./versions/train_pairs.csv) and [`test_pairs.csv`](./versions/test_pairs.csv) provide a split of the dataset into train and test datasets that we used in our experiments.

The file [`labels.csv`](./versions/labels.csv) contains the label for each pair (plagiarized or not).

The file [`all_parameters.jpg`](./versions/all_parameters.jpg) contains the list of all tested parameters for tools.

The file [`optimal_parameters.jpg`](./versions/optimal_parameters.jpg) contains the table with the optimal parameters of the train set.

## How to run?

### 0. Requirements

The project requires `python >=3.9`. To install the necessary Python libraries, run:

```bash
$ pip install -r requirements.txt
```

__DISCLAIMER__: Some tools have a large size or require installation. The inner [README.md](./resources/README.md) contains installation instructions for each tool.

The main pipeline includes two steps.

### 1. Run the tool

First, you should run the necessary tool using [runner.py](./scripts/runner.py).

This script has 3 parameters:
1. `mode` (can select both): `'r'` --- run the tool on the dataset, `'g'` --- generate the uniform report for the given tool.
2. `tool`: a name of tool you want to run: `'sherlock'`, `'sim'`, `'moss'`, `'dolos'`, `'jplag'`, `'bplag'`. You can find instructions for adding a new tool at the end of the README.
3. `version`: the dataset version (`'1'` means the "raw" version and `'2'` means the "template-free" version).

For example, if you want to run and generate a report for `sim` on the first version of the dataset, run the following command:

```bash
$ python3.9 ./scripts/runner.py --mode=rg --tool=sim --version=1
```

Please note that some tools may run for a long time (for example, BPlag or MOSS), so it's better to run with the `r`-mode only, wait for the results, and then generate the uniform report with the `g`-mode:

```bash
$ python3.9 ./scripts/runner.py --mode=r --tool=bplag --version=2

# ... running ...

$ python3.9 ./scripts/runner.py --mode=g --tool=bplag --version=2
'[OK] Report generated'
'You can find a final report in ./reports/bplag/version_2/'
```

Also, in the code for algoritm wrappers, you can change their configuration (see fields like `self.key_n`, `self.key_w`, etc.).

### 2. Calculate the metrics

When the reports are created for all the necessary tools, you can start calculating the metrics by using [metrics.py](./scripts/metrics.py). This script also three parameters:

1. `tool`: names of the tools for which you want to calculate the metrics.
2. `version`: dataset version.
3. `metrics`: metrics that you want to caluclate: `'recall'`, `'precision'`, `'f_1'`, `'f_b'`.

For example, if you want to calulate `precision` and `recall` for `moss` and `sherlock`, run the following command:

```bash
$ python3.9 ./scripts/metrics.py --tool moss sherlock --version=1 --metrics precision recall
```

If you want to calclate metrics for all the tools or calculate all the metrics, you can omit the corresponding flag:

```bash
# compare all tools by precision and recall
$ python3.9 --version=1 --metrics precision recall

# compare dolos and jplag by all metrics (precision, recall, F_1 and F_beta)
$ python3.9 --version=1 --tool dolos jplag

# compare all tools by all metrics
$ python3.9 --version=1
```

## Adding a new tool

To add a new tool, you need to implement an inheritor of the [Algorithm](./scripts/algorithm.py) class. You need to implement how your algorithm runs on a pair of programs and write how a similarity is extracted for a given pair. For a better understanding of how to run external processes, see the examples of already implemented algorithms.
