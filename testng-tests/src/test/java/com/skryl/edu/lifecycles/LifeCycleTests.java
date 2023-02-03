package com.skryl.edu.lifecycles;

import org.testng.annotations.*;

/**
 * @author Skryl D.V. on 2023-01-20
 */
public class LifeCycleTests {

    @BeforeSuite
    void beforeSuite() {
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("BeforeTest");
    }

    @BeforeGroups
    void beforeGroups() {
        System.out.println("BeforeGroups");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("BeforeMethod");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("AfterSuite");
    }

    @AfterTest
    void afterTest() {
        System.out.println("AfterTest");
    }

    @AfterGroups
    void afterGroups() {
        System.out.println("AfterGroups");
    }

    @AfterClass
    void afterClass() {
        System.out.println("AfterClass");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("AfterMethod");
    }

    @Test(groups = {"group 1"})
    void test1() {
        System.out.println("Test");
    }
}
