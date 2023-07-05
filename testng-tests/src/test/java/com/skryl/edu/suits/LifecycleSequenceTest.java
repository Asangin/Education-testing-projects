package com.skryl.edu.suits;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Skryl D.V. on 2023-06-26
 */
@Slf4j
public class LifecycleSequenceTest extends BaseTest {

    @BeforeMethod
    void before() {
        log.info(getClass().getSimpleName() + " BeforeMethod before");
    }

    @Test
    void test1() {
      log.info("Inside test assertion");
    }
}
