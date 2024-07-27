package com.skryl.edu.listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Skryl D.V. on 2023-02-20
 */
@Slf4j
public class TestInfo implements ITestListener, IInvokedMethodListener {
    private String testNumber;

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        if(method.getTestMethod().isBeforeSuiteConfiguration()) {
            System.out.println("beforeInvocation: Suite");
            System.out.println("Context name: %s".formatted(context.getName()));
        }

        if(method.getTestMethod().isBeforeClassConfiguration()) {
            System.out.println("beforeInvocation: Class");
        }

        if(method.getTestMethod().isBeforeTestConfiguration()) {
            System.out.println("beforeInvocation: Test");
        }

        if(method.getTestMethod().isBeforeMethodConfiguration()) {
            System.out.println("beforeInvocation: Method");
        }

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        if(method.getTestMethod().isAfterSuiteConfiguration()) {
            System.out.println("afterInvocation: Suite");
        }

        if(method.getTestMethod().isAfterClassConfiguration()) {
            System.out.println("afterInvocation: Class");
        }

        if(method.getTestMethod().isAfterTestConfiguration()) {
            System.out.println("afterInvocation: Test");
        }

        if(method.getTestMethod().isAfterMethodConfiguration()) {
            System.out.println("afterInvocation: Method");
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        testNumber = getTestNumber(iTestResult);
        log.info("===============Test %s START===============".formatted(testNumber));
        // Send result to report
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        iTestResult.getMethod().getGroups();
        log.info("===============TEST %s PASSED===============".formatted(testNumber));

        // Send result to report
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("===============TEST %s FAILED===============".formatted(testNumber));
        log.info("Fail reason: %s".formatted(iTestResult.getThrowable().getMessage()));
        // Send result to report
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("===============TEST %s SKIPPED===============".formatted(testNumber));
        // Send result to report
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info("List of test methods:");
        List.of(iTestContext.getAllTestMethods()).forEach(System.out::println);
        log.info("List of classes:");
        Arrays.stream(iTestContext.getAllTestMethods())
                        .map(ITestNGMethod::getRealClass)
                .peek(c -> System.out.println(c.getSimpleName()))
                                .forEach(p -> Arrays.stream(p.getAnnotations())
                                        .forEach(el -> System.out.println(el.annotationType().getSimpleName())));

        log.info("onStart");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info("onFinish");
    }

    private String getTestNumber(ITestResult iTestResult) {
        try {
            String testDescription = iTestResult.getMethod().getDescription();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(testDescription);
            if (matcher.find()) {
                return matcher.group();
            }
        } catch (NullPointerException e) {
            log.error("ERROR: Couldn't get test number, test has empty description.");
        }
        return "number not present in description";
    }
}
