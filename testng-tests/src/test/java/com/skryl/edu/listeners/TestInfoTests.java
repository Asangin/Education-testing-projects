package com.skryl.edu.listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2023-02-20
 */
@Slf4j
public class TestInfoTests {

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Tear down method");
    }

    @Test(description = "Test #1 Will be successful")
    public void successTest() {
        log.info("Test will be successful");
        assertThat("Word").isEqualTo("Word");
    }

    @Test(description = "Test #2 Will be fail")
    public void failedTest() {
        log.info("Test will fail!");
        assertThat(false).isTrue();
    }
}
