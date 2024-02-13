package com.skryl.edu.listeners;

import org.testng.*;

import java.util.List;

/**
 * @author Skryl D.V. on 2024-01-16
 */
public class CollectorListener implements IMethodInterceptor, ISuiteListener, ITestListener {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        System.out.println(list);
        return list;
    }

    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
        System.out.println("SUITE ON START");
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println("ON START");
    }
}
