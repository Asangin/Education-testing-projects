# Experiment with Java Playwright framework

> Try to use modern E2E tool with Java, instead of JS

Link to [Getting started](https://playwright.dev/java/docs/intro) tutorial

## Setup container with test application using Maven plugin

[Maven plugin](https://github.com/fabric8io/docker-maven-plugin)
[Documentation](http://dmp.fabric8.io/)

Important note that this plugin run container before `pre-integration-test` and stop container  after `post-integration-test`,
so obviously it should be integration test, by convention, failsafe plugin executes integration test whose name starts
with IT, or ends with IT or ITCase
[(link on official documentation).](https://maven.apache.org/surefire/maven-failsafe-plugin/examples/inclusion-exclusion.html)

To test it with maven:
```bash
mvn clean verify
```

