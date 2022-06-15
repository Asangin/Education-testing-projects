package com.skryl.edu.junit5;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2022-06-15
 */
public class FlakyJunitTestCases {

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
