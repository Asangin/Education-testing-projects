package com.skryl.edu.preconditions;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

/**
 * @author Skryl D.V. on 2024-07-02
 */
public class BaseIntegration {

    @BeforeSuite(alwaysRun = true)
    void baseIntegrationPreconditions() {
        System.out.println("BaseIntegration");
    }

    @BeforeClass(alwaysRun = true)
    void baseIntegrationClassPreconditions() {
        System.out.println("BaseIntegration class precondition");
    }

}
