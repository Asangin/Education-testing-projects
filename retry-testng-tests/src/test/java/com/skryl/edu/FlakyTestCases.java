package com.skryl.edu;

import com.skryl.edu.utils.RetryAnalyzer;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2022-06-15
 */
public class FlakyTestCases {

    @BeforeSuite
    public void suiteSetUp() {
        System.out.println("BeforeSuite set up");
    }

    @BeforeTest
    public void testSetUp() {
        System.out.println("BeforeTest set up");
    }

    @BeforeClass
    public void classSetUp() {
        System.out.println("BeforeClass set up");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeMethod pre-condition");
    }

    @AfterSuite
    public void suiteTearDown() {
        System.out.println("AfterSuite tear down");
    }

    @AfterTest
    public void testTeardown() {
        System.out.println("AfterTest tear down");
    }

    @AfterClass
    public void classTearDown() {
        System.out.println("AfterClass tear down");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("AfterMethod post-condition");
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