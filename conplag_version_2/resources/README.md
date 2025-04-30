# Tools for source code plagiarism detection

This folder contains resources for software plagiarism detection tools.

The following are the requirements for each tool.

## SIM

* sim_java (can be found in the [sim folder](./sim/sim_java) or by following [this link](https://github.com/mpanczyk/sim))

## Sherlock

* sherlock (can be found in the [sherlock folder](./sherlock/sherlock) or by following [this link](https://github.com/diogocabral/sherlock))


## JPlag

* Java 11
* jplag-2.12.1-SNAPSHOT-jar-with-dependencies.jar (can be found in the [jplag folder](./jplag/jplag-2.12.1-SNAPSHOT-jar-with-dependencies.jar) or by following [this link](https://github.com/jplag/JPlag/releases/tag/v2.12.1-SNAPSHOT))

## MOSS

* [moss.py client](https://github.com/soachishti/moss.py) online

## Dolos

* GitHub repository: [https://dolos.ugent.be/guide/installation.html](https://dolos.ugent.be/guide/installation.html)
*  Installation guide: [https://dolos.ugent.be/guide/installation.html](https://dolos.ugent.be/guide/installation.html)

## BPlag

* Java 8 (later versions do not work with BPlag)
* BPlag can be downloaded by following  [this link](https://github.com/hjc851/BPlag/releases/download/0.1/BPlag-0.1.zip)
* You should unzip BPlag-0.1.jar into the [bplag](./bplag/) folder
* Also, it's important to place `rt.jar` (Java runtime library) into the [bplag](./bplag/) folder
* [utils.jar](./bplag/utils.jar) obtained from [Utils.java](./bplag/Utils.java) is a JAR with the template and I/O code for BPlag to work correctly
