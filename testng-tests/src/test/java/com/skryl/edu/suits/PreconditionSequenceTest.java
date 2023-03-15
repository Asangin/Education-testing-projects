package com.skryl.edu.suits;

import com.skryl.edu.User;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author Skryl D.V. on 2023-03-14
 */
@Slf4j
@Listeners({
        com.skryl.edu.listeners.BeforeListener1.class,
        com.skryl.edu.listeners.BeforeListener2.class,
        com.skryl.edu.listeners.PreSetupUser.class
})
public class PreconditionSequenceTest {

    @Test
    void test1() {
        log.info("test1 body");
    }

    @Test
    void useContextTest(ITestContext context) {
        var user = (User)context.getAttribute("testUser");
        log.info("User name: %s".formatted(user.getName()));
        log.info("User age: %d".formatted(user.getAge()));
    }
}
