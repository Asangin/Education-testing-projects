package com.skryl.edu.preconditions;

import org.testng.annotations.AfterSuite;

/**
 * @author Skryl D.V. on 2024-07-02
 */
public interface AfterSmokeSuitePostcondition {

    @AfterSuite(alwaysRun = true)
    default void afterSmokeSuitePostcondition() {
        System.out.println("AfterSmokeSuitePostcondition");
    }

}
