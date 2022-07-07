package com.skryl.edu.timeout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author Skryl D.V. on 2022-06-27
 */
@Timeout(3)
public class TimeoutTests {

    @BeforeEach
    @Timeout(2)
    void setUp() {
        // fails if execution time exceeds 2 seconds
    }

    @Test
    void testMethodOne() throws InterruptedException {
        // fails if execution time exceeds 3 seconds, because of global timeout on a class level
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    @Timeout(5)
    void testMethodTwo() throws InterruptedException {
        // pass because this
        TimeUnit.SECONDS.sleep(4);
    }

    @Test
    void testGetValue() {
        Assertions.assertTimeout(Duration.ofSeconds(3), this::getValue);
    }

    void getValue() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }
}
