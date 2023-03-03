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
Using multiple precondition methods and there execution sequence
in [MultipleLifecycleTests.java](src/test/java/com/skryl/edu/lifecycles/MultipleLifecycleTests.java)

## Parametrization test using the data provider

[DataProvider.java](src/test/java/com/skryl/edu/dataprovider/DataProvider.java) contains data that will use in the
test [DataProviderTests.java](src/test/java/com/skryl/edu/dataprovider/DataProviderTests.java).
Also, our provider consists of a set of data, and every data value will be run in a separate test.

## TestNG Listeners

[doc](https://testng.org/doc/documentation-main.html#testng-listeners)

### ITestListener

[ITestListener](https://javadoc.io/doc/org.testng/testng/6.13/org/testng/ITestListener.html) can be helpful in gathering
test info for some custom reports or collecting test execution statistics to [Elasticsearch](https://www.elastic.co/)
for further analysis in [Grafana](https://grafana.com/). Example of Listener
in  [TestInfo.java](src/test/java/com/skryl/edu/listeners/TestInfo.java) and how to apply this listener shown
in [log-test-info-suite.xml](src/test/resources/listener/log-test-info-suite.xml)