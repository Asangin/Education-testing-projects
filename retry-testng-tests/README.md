# Retry for TestNG flaky tests

> The purpose of that project is to try different retry mechanisms to avoid flaky tests to test product functionality
> rather than an environmental side effect.

[TestNG retries](https://testng.org/doc/documentation-main.html#rerunning)
  Like TestNG documentation said, we can re-run only failed tests tha will store in testng-failed.xml or use
  IRetryAnalyzer interface to specify a retry logic by ourselves for a particular failed test cases.

So let's run flaky-test.xml with AnnotationTransformer listener that add RetryAnalyzer.class to every test
```bash
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/flaky-test.xml
```

or we can try re-run mechanism via testng-failed.xml file. To do that need to run test
```bash
mvn clean test
```