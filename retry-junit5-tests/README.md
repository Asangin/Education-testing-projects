# Retry for flaky Junit5 tests

> The purpose of that project is to try different retry mechanisms to avoid flaky tests to test product functionality
> rather than an environmental side effect.

There is a couple variant we have:

- [maven fail retry](https://maven.apache.org/surefire/maven-surefire-plugin/examples/rerun-failing-tests.html)
  NOTE : This feature is supported for JUnit 4.x, and (since 3.0.0-M4) JUnit 5.x.

```bash
mvn clean test -Dtest=FlakyJunitTestCases
mvn clean test -Dtest=FlakyJunitTestCases -Dsurefire.rerunFailingTestsCount=3 
mvn allure:serve
```

With this option, maven will retry failed test, and we will see such report:

```
[INFO] 
[WARNING] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Flakes: 2
[INFO] 
```

The important thing here is that the maven retried failed test after executing all the tests, so keep in mind that the
test(method) in such case should be independent. Every "rerunFailingTestsCount" is a re-run of all of the failed tests.

- [Test-retry-gradle-plugin](https://github.com/gradle/test-retry-gradle-plugin)

[//]: # (TODO add gradle)