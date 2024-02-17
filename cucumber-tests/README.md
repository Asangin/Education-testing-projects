# Cucumber BDD approach testing

> Use BDD scenario approach and increase scripting skills

Link to [Cucumber-JVM](https://cucumber.io/docs/installation/java/)


## run tests via commandline

### Cucumber basic concepts

```bash
mvn clean test -Dgroups="RegressionTests"
```

```bash
mvn clean test -DexcludedGroups="NightlyBuildTest"
```

```bash
mvn clean test -Dtest=MenuManagementV2Test
```

```bash
mvn clean test -Dtest=MenuManagementV2Test -Dgroups="RegressionTests"
```

### Cucumber data tables tests

```bash
mvn clean test -Dtest=DataTablesTests
```

### Cucumber Scenario outline examples

```bash
mvn clean test -Dtest=ScenarioOutlineExampleTest
```
