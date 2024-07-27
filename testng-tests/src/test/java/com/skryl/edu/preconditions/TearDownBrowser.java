package com.skryl.edu.preconditions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * @author Skryl D.V. on 2024-07-02
 */
public interface TearDownBrowser {

    @AfterMethod
    default void tearDownBrowser() {
        System.out.println("tearDownBrowser");
    }

}
