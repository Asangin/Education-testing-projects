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
        System.out.println("Common pre-condition");
        Allure.step("Common pre-condition");
    }

    @AfterAll
    static void postCondition() {
        System.out.println("Common post-condition");
        Allure.step("Common post-condition");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("Before each test");
        Allure.step("Before each test");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("After each test");
        Allure.step("After each test");
    }

    @Nested
    @DisplayName("Suite 1")
    class Suite1 {

        @BeforeEach
        void setUp() {
            System.out.println("Setup for test in suite 1");
            Allure.step("Setup for test in suite 1");
        }

        @AfterEach
        void tearDown() {
            System.out.println("Teardown for test in suite 1");
            Allure.step("Teardown for test in suite 1");
        }

        @Test
        @DisplayName("Test 1")
        void verifyThatRegularSubscriptionApplyToAdmin() {
            System.out.println("Test 1 in Suite 1");
            Allure.step("Test 1 in Suite 1");
        }

        @Test
        @DisplayName("Test 2")
        void verifyThatRegularSubscriptionApplyToModerator() {
            System.out.println("Test 2 in Suite 1");
            Allure.step("Test 2 in Suite 1");
        }

        @Test
        @DisplayName("Test 3")
        void verifyThatRegularSubscriptionApplyToUser1() {
            System.out.println("Test 3 in Suite 1");
            Allure.step("Test 3 in Suite 1");
        }

    }

    @Nested
    @DisplayName("Suite 2")
    class Suite2 {

        @BeforeEach
        void setUp() {
            System.out.println("Setup for test in suite 2");
            Allure.step("Setup for test in suite 2");
        }

        @AfterEach
        void tearDown() {
            System.out.println("Teardown for test in suite 2");
            Allure.step("Teardown for test in suite 2");
        }

        @Test
        @DisplayName("Test 1")
        void verifyThatRegularSubscriptionApplyToAdmin() {
            System.out.println("Test 1 in Suite 2");
            Allure.step("Test 1 in Suite 2");
        }

        @Test
        @DisplayName("Test 2")
        void verifyThatRegularSubscriptionApplyToModerator() {
            System.out.println("Test 2 in Suite 2");
            Allure.step("Test 2 in Suite 2");
        }

        @Test
        @DisplayName("Test 3")
        void verifyThatRegularSubscriptionApplyToUser1() {
            System.out.println("Test 3 in Suite 2");
            Allure.step("Test 3 in Suite 2");
        }

    }

}
