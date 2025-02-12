
# Project #1: Deterministic Finite Automata

* Author: Jordan Pittman, Caleb Pollock
* Class: CS361 Section 1
* Semester: Spring 2025

## Overview

This is a java program designed to simulate deterministic finite
automata. It allows for the creation of DFAs, adding states, and
adding state transitions.

## Reflection

### Caleb

Working on this project was pretty basic for me. I was responsible
for adding test cases and documentation to the code. I spent
some time reading through Jordan's implimentation and the existing
tests, and then added documentation where I felt it was needed and
added some unit tests to cover some of the edge cases that didn't
look like they were handled in the initial tests. That is it.

## Compiling and Using
   
To compile the test cases, use the following command, replacing
all instances of <path to junit jar> with the path to the junit
jar on your system:   
    
```
$ javac -cp .:<path to junit jar> ./test/dfa/DFATest.java   
```
   
To run the tests, use the following command:   
   
```
$ java -cp .:<path to junit jar>:/usr/share/java/hamcrest/core.jar org.junit.runner.JUnitCore test.dfa.DFATest   
```

To use the classes outside of this program, create a jar using
the following sequence of commands:

```
$ mkdir build
$ javac -d build fa/*.java
$ jar cvf CS361.jar *
```

Then you can link the project files with other projects
by using the -cp .:<path to jar> when compiling.

## Sources Used

* https://stackoverflow.com/questions/9395207/how-to-include-jar-files-with-java-file-and-compile-in-command-prompt
* https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashSet.html 
* https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html 
