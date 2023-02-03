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

## Test LifeCycle

It is discovered that [package](src/test/java/com/skryl/edu/lifecycles) provides a simple view of which annotated method
is running in different circumstances.

Lifecycle execution sequence [LifeCycleTests.java](src/test/java/com/skryl/edu/lifecycles/LifeCycleTests.java)
Using multiple precondition methods and there execution sequence in [MultipleLifecycleTests.java](src/test/java/com/skryl/edu/lifecycles/MultipleLifecycleTests.java)
