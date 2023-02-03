package com.skryl.edu.lifecycles;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Skryl D.V. on 2023-01-22
 */
public class MultipleLifecycleTests {
    @BeforeTest
    void beforeTest1() {
        System.out.println("BeforeTest1");
    }

    @BeforeTest
    void beforeTest2() {
        System.out.println("BeforeTest2");
    }

    @Test
    void test1() {
        System.out.println("Test");
    }
}
