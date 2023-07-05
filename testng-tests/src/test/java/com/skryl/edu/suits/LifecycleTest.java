package com.skryl.edu.suits;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * @author Skryl D.V. on 2023-06-27
 */
@Slf4j
public class LifecycleTest extends BaseTest {
    @Test
    void testLifecycle() {
        log.info("Inside test assertion");
    }
}
