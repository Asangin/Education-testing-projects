package com.skryl.edu.preconditions;

import org.testng.annotations.BeforeSuite;

/**
 * @author Skryl D.V. on 2024-07-05
 */
public interface BeforeIntegrationDependentSuitePrecondition {
    @BeforeSuite(alwaysRun = true, dependsOnMethods = {"beforeSuitePrecondition"})
    default void aDependentMethod() {
        System.out.println("BeforeIntegrationDependentSuitePrecondition");
    }
}
