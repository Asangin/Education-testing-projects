package com.skryl.edu.suits;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @author Skryl D.V. on 2023-04-25
 */
@Slf4j
public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void suitePreConditions() {
        log.info("BeforeSuite");
    }

    @AfterSuite(alwaysRun = true)
    public void suitePostConditions() {
        log.info("AfterSuite");
    }
}
