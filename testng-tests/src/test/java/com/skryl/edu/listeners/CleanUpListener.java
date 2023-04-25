package com.skryl.edu.listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * @author Skryl D.V. on 2023-04-25
 */
@Slf4j
public class CleanUpListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        if (method.isTestMethod()) {
            log.info("afterInvocation test");
        }

    }
}
