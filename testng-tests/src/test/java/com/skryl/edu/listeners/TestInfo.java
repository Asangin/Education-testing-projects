package com.skryl.edu.listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Skryl D.V. on 2023-02-20
 */
@Slf4j
public class TestInfo implements ITestListener {
    private String testNumber;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        testNumber = getTestNumber(iTestResult);
        log.info("===============Test %s START===============".formatted(testNumber));
        // Send result to report
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
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
