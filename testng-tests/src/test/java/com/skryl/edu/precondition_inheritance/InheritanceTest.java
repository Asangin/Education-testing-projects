package com.skryl.edu.precondition_inheritance;

import org.testng.annotations.Test;

/**
 * @author Skryl D.V. on 2024-07-04
 */
public class InheritanceTest extends BaseTwo {
    @Test
    void test1() {
        System.out.println("Smoke Test №1");
    }

    @Test
    void test2() {
        System.out.println("Smoke Test №2");
    }

    @Test
    void test3() {
        System.out.println("Integration Test №1");
    }

    @Test
    void test4() {
        System.out.println("Integration Test №2");
    }
}
