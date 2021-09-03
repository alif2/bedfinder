# Bedfinder

A utility for converting the output of [Hi-C Breakfinder](https://github.com/dixonlab/hic_breakfinder) to [Bedtools](https://bedtools.readthedocs.io/en/latest/)-compatible files.

# Prerequisites
Java 11+

# Installation
Bedfinder is distributed as a JAR file which can be downloaded from the Releases listed on the sidebar.

# How to run
```java -jar bedfinder.jar <input file>, <output file>```

The input file is expected to be a *.breaks.txt file. The output is a tabbed-delimited text file, which can be a .txt or .bed file.
