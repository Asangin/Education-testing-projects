package com.skryl.edu.utils;

import io.qameta.allure.Allure;
import org.testng.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Skryl D.V. on 2023-04-06
 */
public class AllureAttachmentListener implements IInvokedMethodListener {
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        if (method.isTestMethod()) { // triggers only after @Test
            Allure.addAttachment("My attachment", "My attachment content");
            var content = Paths.get(System.getProperty("user.dir") + "/README.md");
            try (InputStream is = Files.newInputStream(content)) {
                Allure.addAttachment("My attachment", "binary", is, "md");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
