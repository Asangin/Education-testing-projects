package com.skryl.edu.preconditions;

import org.testng.annotations.Test;

/**
 * @author Skryl D.V. on 2024-07-05
 */
public class DependencyPreconditionTest implements BeforeIntegrationDependentSuitePrecondition, BeforeSuitePrecondition {

    @Test
    void test1() {
        System.out.println("Integration Test");
    }

}
