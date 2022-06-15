package com.skryl.edu;

import com.skryl.edu.utils.RetryAnalyzer;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2022-06-15
 */
public class FlakyTestCases {

    @BeforeClass
    public static void classSetUp() {
        System.out.println("Test class set up");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Every test method pre-condition");
    }

    @AfterClass
    public static void classTearDown() {
        System.out.println("Test class tear down");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Every test method post-condition");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
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