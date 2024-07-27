package com.skryl.edu.preconditions;

import org.testng.annotations.BeforeSuite;

/**
 * @author Skryl D.V. on 2024-07-02
 */
public interface BeforeSuitePrecondition {

    @BeforeSuite(alwaysRun = true)
    default void beforeSuitePrecondition() {
        System.out.println("BeforeSuitePrecondition");
    }

}
