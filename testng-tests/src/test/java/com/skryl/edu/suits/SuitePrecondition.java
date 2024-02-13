package com.skryl.edu.suits;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @author Skryl D.V. on 2023-11-21
 */
public class SuitePrecondition {

    @BeforeSuite(alwaysRun = true)
    public void suitePreConditions() {
        System.out.println("Before suite precondition");
    }

    @AfterSuite(alwaysRun = true)
    public void suitePostConditions() {
        System.out.println("After suite precondition");
    }

}
