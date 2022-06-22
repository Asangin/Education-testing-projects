package com.skryl.edu.junit5;


import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2022-06-15
 */
public class FlakyJunitTestCase {

    @BeforeAll
    static void precondition() {
        System.out.println("BeforeAll precondition");
        var actual = Math.round( Math.random() );
        assertThat(actual).isEqualTo(1);
    }

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach setup");
    }

    @AfterAll
    static void postCondition() {
        System.out.println("AfterAll postCondition");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach tearDown");
    }

    @Test
    void test1() {
        System.out.println("Flaky test 1");
        var actual = Math.round( Math.random() );
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void test2() {
        System.out.println("Flaky test 2");
        var actual = Math.round( Math.random() );
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void test3() {
        System.out.println("Flaky test 3");
        var actual = Math.round( Math.random() );
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void test4() {
        System.out.println("Flaky test 4");
        var actual = Math.round( Math.random() );
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void test5() {
        System.out.println("Flaky test 5");
        var actual = Math.round( Math.random() );
        assertThat(actual).isEqualTo(0);
    }
}
