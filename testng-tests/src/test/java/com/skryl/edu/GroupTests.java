package com.skryl.edu;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Skryl D.V. on 2023-09-01
 */
@Slf4j
public class GroupTests {

    @BeforeMethod(alwaysRun = true)
    void before() {
        log.info("before method");
    }

    @Test(groups = {"a"})
    void test1() {
        log.info("test1");
    }

    @Test(groups = {"a", "b"})
    void test2() {
        log.info("test2");
    }

    @Test(groups = {"b", "a"})
    void test3() {
        log.info("test3");
    }

    @Test(groups = {"a"})
    void test4() {
        log.info("test4");
    }

    @Test(groups = {"a"})
    void test5() {
        log.info("test5");
    }

}
