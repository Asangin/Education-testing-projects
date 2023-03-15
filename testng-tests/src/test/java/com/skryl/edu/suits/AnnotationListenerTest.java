package com.skryl.edu.suits;

import lombok.extern.slf4j.Slf4j;
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
public class AnnotationListenerTest {

    @Test
    public void successTest() {
        log.info("Test body");
        assertThat("Word").isEqualTo("Word");
    }
}
