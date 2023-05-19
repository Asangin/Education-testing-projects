package com.skryl.edu.utils;

import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Skryl D.V. on 2023-05-10
 */
public class AllureScreenShotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage capture = new Robot().createScreenCapture(screenRect);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(capture, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            Allure.addAttachment("ScreenShot", new ByteArrayInputStream(bytes));
        } catch (IOException | AWTException e) {
            throw new RuntimeException(e);
        }
    }

}
