package com.skryl.edu.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

/**
 * @author Skryl D.V. on 2024-02-17
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@ScenarioOutlineExample")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.skryl.edu.stepdefenitions,com.skryl.edu.hooks")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value =
        "pretty, " +
                "html:target/SystemTestReports/reports.html, " +
                "json:target/SystemTestReports/json/report.json, " +
                "junit:target/SystemTestReports/junit/report.xml"
)
public class ScenarioOutlineExampleTest {
}
