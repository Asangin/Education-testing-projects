package com.skryl.edu.listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;

/**
 * @author Skryl D.V. on 2023-03-14
 */
@Slf4j
public class BeforeListener1 implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        log.info("Precondition 1");
    }
}
