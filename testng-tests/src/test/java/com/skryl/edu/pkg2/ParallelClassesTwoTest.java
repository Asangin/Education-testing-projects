package com.skryl.edu.pkg2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Skryl D.V. on 2022-05-06
 * Copyright © 2022 Perenio. All rights reserved.
 */
public class ParallelClassesTwoTest {
    @BeforeClass
    public void beforeClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-class. Thread id is: " + id);
    }

    @Test(groups = {"Level 1"})
    public void testMethodOne() {
        long id = Thread.currentThread().getId();
        var cls = getClass().getSimpleName();
        var pkg = getClass().getPackageName();
        var msg = "Level 1 test-method 1, In package: %s and class: %s, Thread id is: %s".formatted(pkg, cls, id);
        System.out.println(msg);
    }

    @Test(groups = {"Level 2"})
    public void dependenceTestMethodTwo() {
        long id = Thread.currentThread().getId();
        var cls = getClass().getSimpleName();
        var pkg = getClass().getPackageName();
        var msg = "Level 2 test-method 2, In package: %s and class: %s, Thread id is: %s".formatted(pkg, cls, id);
        System.out.println(msg);
    }

    @AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-class. Thread id is: " + id);
    }
}
