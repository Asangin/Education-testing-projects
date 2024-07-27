package com.skryl.edu.suits;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * @author Skryl D.V. on 2023-04-25
 */
@Slf4j
public class BaseTest {

    @BeforeSuite
    public void suitePreConditions() {
        log.info("BeforeSuite");
    }

    @AfterSuite
    public void suitePostConditions() {
        log.info("AfterSuite");
    }

    @BeforeTest
    public void testPrecondition() {
        log.info("BeforeTest");
    }

    @BeforeMethod
    public void init() {
        log.info(getClass().getSimpleName() + " BeforeMethod init");
    }
}
