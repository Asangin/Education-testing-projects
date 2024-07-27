package com.skryl.edu.preconditions;

import org.testng.annotations.AfterMethod;

/**
 * @author Skryl D.V. on 2024-07-02
 */
public interface CleanupDatabases {

    @AfterMethod
    default void cleanupDatabases() {
        System.out.println("cleanupDatabases");
    }

}
