package com.skryl.edu.preconditions;

import org.testng.annotations.BeforeSuite;

/**
 * @author Skryl D.V. on 2024-07-02
 */
public class BaseSmoke {

    @BeforeSuite(alwaysRun = true)
    void baseSmokePreconditions() {
        System.out.println("BaseSmoke");
    }

}
