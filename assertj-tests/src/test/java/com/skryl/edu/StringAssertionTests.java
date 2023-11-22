package com.skryl.edu;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2023-09-15
 */
public class StringAssertionTests {

    @Test
    void emptyString() {
        var emptyString = "";
        assertThat(emptyString)
                .as("Expected 'str' as a String")
                .isNotBlank();
    }

    @Test
    void nullString() {
        String emptyString = null;
        assertThat(emptyString)
                .isNotBlank();
    }

    @Test
    void nullStringNative() {
        var env = System.getenv("DO_NOT_EXIST");
        if(env == null || env.isEmpty()) {
            System.out.println("No env: " + env);
        }
    }
}
