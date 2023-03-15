package com.skryl.edu.listeners;

import com.skryl.edu.User;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * @author Skryl D.V. on 2023-03-14
 */
public class PreSetupUser implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        var user = new User();
        user.setName("Dmytro");
        user.setAge(37);
        context.setAttribute("testUser", user);
        IInvokedMethodListener.super.beforeInvocation(method, testResult, context);
    }
}
