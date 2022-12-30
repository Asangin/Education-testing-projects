package com.skryl.edu.pkg1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Skryl D.V. on 2022-05-06
 * Copyright © 2022 Perenio. All rights reserved.
 */
public class ParallelMethodTest {
    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);
    }

    @Test(groups = "Level 1")
    public void testMethodsOne() {
        long id = Thread.currentThread().getId();
        var cls = getClass().getSimpleName();
        var pkg = getClass().getPackageName();
        var msg = "Level 1 test-method One, In package: %s and class: %s, Thread id is: %s".formatted(pkg, cls, id);
        System.out.println(msg);
    }

    @Test(groups = "Level 2")
    public void testMethodsTwo() {
        long id = Thread.currentThread().getId();
        var cls = getClass().getSimpleName();
        var pkg = getClass().getPackageName();
        var msg = "Level 2 test-method Two, In package: %s and class: %s, Thread id is: %s".formatted(pkg, cls, id);
        System.out.println(msg);
    }

    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread id is: " + id);
    }
}
