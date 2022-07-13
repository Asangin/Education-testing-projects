package com.skryl.edu.utils;

import org.apache.commons.lang3.math.NumberUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Skryl D.V. on 2022-06-08
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    static int overallFailingTest = 0;
    int counter = 0;
    static final int RETRY_LIMIT;
    static final int FAILURE_LIMIT;

    static {
        var fl = System.getenv("FAILURE_LIMIT");
        if (NumberUtils.isDigits(fl)) {
            FAILURE_LIMIT = Integer.parseInt(fl);
        } else {
            FAILURE_LIMIT = 5;
        }
        System.out.println("FAILURE_LIMIT: " + FAILURE_LIMIT);

        var rl = System.getenv("RETRY_LIMIT");
        if (NumberUtils.isDigits(rl)) {
            RETRY_LIMIT = Integer.parseInt(rl);
        } else {
            RETRY_LIMIT = 3;
        }
        System.out.println("RETRY_LIMIT: " + RETRY_LIMIT);
    }

    @Override
    public boolean retry(ITestResult iTestResult) {
        System.out.println("Failed test count: " + overallFailingTest);
        overallFailingTest++;
        if (counter < RETRY_LIMIT && overallFailingTest < FAILURE_LIMIT) {
            counter++;
            return true;
        }
        return false;
    }

}
