package com.skryl.edu.preconditions;

import org.testng.annotations.Test;

/**
 * @author Skryl D.V. on 2024-07-02
 */
public class BothIntegrationTests extends BaseIntegration implements
        BeforeSuitePrecondition,
        TearDownBrowser,
        CleanupDatabases,
        AfterIntegrationSuitePostcondition {

    @Test
    void test1() {
        System.out.println("Integration Test №1");
    }

    @Test
    void test2() {
        System.out.println("Integration Test №2");
    }

}
