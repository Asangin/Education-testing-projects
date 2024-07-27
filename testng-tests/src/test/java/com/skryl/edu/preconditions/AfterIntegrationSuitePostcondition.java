package com.skryl.edu.preconditions;

import org.testng.annotations.AfterSuite;

/**
 * @author Skryl D.V. on 2024-07-02
 */
public interface AfterIntegrationSuitePostcondition {

    @AfterSuite(alwaysRun = true)
    default void afterIntegrationSuitePostcondition() {
        System.out.println("AfterIntegrationSuitePostcondition");
    }

}
