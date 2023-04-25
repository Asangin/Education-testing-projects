package com.skryl.edu.suits;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2023-03-14
 */
@Slf4j
@Listeners({
        com.skryl.edu.listeners.TestInfo.class,
        com.skryl.edu.listeners.SuiteInfo.class
})
public class AnnotationListenerTest extends BaseTest {

    @BeforeTest(alwaysRun = true)
    public void tearDown() {
        log.info("BeforeTest");
    }

    @AfterMethod(alwaysRun = true)
    public void setUp() {
        log.info("AfterMethod");
    }

    @Test
    public void successTest() {
        log.info("Test body");
        assertThat("Word").isEqualTo("Word");
    }

    @Test
    public void test2() {
        log.info("Test body");
        assertThat("Word").isEqualTo("Word");
    }

    @Test
    public void test3() {
        log.info("Test body");
        assertThat("Word").isEqualTo("Word");
    }
}
