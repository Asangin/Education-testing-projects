package com.skryl.edu.nested;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;

/**
 * @author Skryl D.V. on 2022-07-06
 */
@DisplayName("Similar tests with different pre-conditions or post-conditions")
public class NestedTests {

    @BeforeAll
    static void precondition() {
        System.out.println("Pre-condition");
        Allure.step("Pre-condition");
    }

    @AfterAll
    static void postCondition() {
        System.out.println("Post-condition");
        Allure.step("Post-condition");
    }

    @Nested
    @DisplayName("Suite 1")
    class Suite1 {

        @BeforeEach
        void setUp() {
            System.out.println("setup for suite 1");
            Allure.step("setup for suite 1");
        }

        @AfterEach
        void tearDown() {
            System.out.println("teardown for suite 1");
            Allure.step("teardown for suite 1");
        }

        @Test
        @DisplayName("Test 1")
        void verifyThatRegularSubscriptionApplyToAdmin() {
            System.out.println("Test 1");
            Allure.step("Test 1");
        }

        @Test
        @DisplayName("Test 2")
        void verifyThatRegularSubscriptionApplyToModerator() {
            System.out.println("Test 2");
            Allure.step("Test 2");
        }

        @Test
        @DisplayName("Test 3")
        void verifyThatRegularSubscriptionApplyToUser1() {
            System.out.println("Test 3");
            Allure.step("Test 3");
        }

    }

    @Nested
    @DisplayName("Suite 2")
    class Suite2 {

        @BeforeEach
        void setUp() {
            System.out.println("setup for suite 2");
            Allure.step("setup for suite 2");
        }

        @AfterEach
        void tearDown() {
            System.out.println("teardown for suite 2");
            Allure.step("teardown for suite 2");
        }

        @Test
        @DisplayName("Test 1")
        void verifyThatRegularSubscriptionApplyToAdmin() {
            System.out.println("Test 1");
            Allure.step("Test 1");
        }

        @Test
        @DisplayName("Test 2")
        void verifyThatRegularSubscriptionApplyToModerator() {
            System.out.println("Test 2");
            Allure.step("Test 2");
        }

        @Test
        @DisplayName("Test 3")
        void verifyThatRegularSubscriptionApplyToUser1() {
            System.out.println("Test 3");
            Allure.step("Test 3");
        }

    }

}
