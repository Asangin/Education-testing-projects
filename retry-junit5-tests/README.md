# Retry for flaky Junit5 tests

> The purpose of that project is to try different retry mechanisms to avoid flaky tests to test product functionality
> rather than an environmental side effect.

There is a couple variant we have:

- [maven fail retry](https://maven.apache.org/surefire/maven-surefire-plugin/examples/rerun-failing-tests.html)
  NOTE : This feature is supported for JUnit 4.x, and (since 3.0.0-M4) JUnit 5.x.

```bash
mvn clean test -Dtest=FlakyJunitTestCase
mvn clean test -Dtest=FlakyJunitTestCase -Dsurefire.rerunFailingTestsCount=3 
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

Adding plugin to build.gradle

```groovy
plugins {
    id "org.gradle.test-retry" version "1.4.0"
}
```

and configure test retry

```groovy
tasks.named('test') {
    useJUnitPlatform() // Use JUnit Platform for unit tests.
    testLogging.showStandardStreams = true // enable stdout print to console
    // retry configuration
    retry {
        maxRetries = 3
        maxFailures = 20 // max failure after plugin will stop retry
        failOnPassedAfterRetry = false // don't show failed tests
    }
}
```

execute the test and look at the result in Allure report retry section

```bash
../gradlew clean test --tests FlakyJunitTestCase
```
```bash
../gradlew allureServe
```

Gradle retry plugin does the same as a Maven retry, runs all tests, retries all failed tests again, and so on...
Repeatedly run all precondition Before\After methods, but the test should not depend on other tests, only on
precondition methods.

[//]: # (TODO check lifecycle for suite for maven and gradle plugins)