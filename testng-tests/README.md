# TestNG feature

> The goal is to provide examples of TestNG features

## Parallel test suites

This packages contains
classes [ParallelClassesOneTest.java](src/test/java/com/skryl/edu/pkg1/ParallelClassesOneTest.java),
[ParallelClassesTwoTest.java](src/test/java/com/skryl/edu/pkg2/ParallelClassesTwoTest.java) that will run in parallel
using this [test suite](src/test/resources/parallel-test-classes-suite.xml).

## Package scope test suite

In this [test suite](src/test/resources/package-scope-test-suite.xml) we can specify the package and all test classes
that are in this package will run. Noted! that package scope does not work recursively, so only test classes that belong
to specify package will run. 