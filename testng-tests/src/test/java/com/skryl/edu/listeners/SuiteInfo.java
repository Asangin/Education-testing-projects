package com.skryl.edu.listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * @author Skryl D.V. on 2023-03-14
 */
@Slf4j
public class SuiteInfo implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
        log.info("Listener is run before suite started.");
    }
}
