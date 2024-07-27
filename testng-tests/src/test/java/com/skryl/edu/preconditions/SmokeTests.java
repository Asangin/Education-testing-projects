package com.skryl.edu.preconditions;

import org.testng.annotations.Test;

/**
 * @author Skryl D.V. on 2024-07-02
 */
public class SmokeTests implements BeforeSuitePrecondition, AfterSmokeSuitePostcondition {
    @Test
    void test1() {
        System.out.println("Smoke Test №1");
    }

    @Test
    void test2() {
        System.out.println("Smoke Test №2");
    }
}
