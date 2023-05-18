package com.team.test.selenium.tests;


import com.team.selenium.DriverPool;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;

public class Listener implements ITestListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class.getName());


    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        WebDriver webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        try {
            takeSnapShot(webDriver);
        } catch (Exception e) {
            throw new RuntimeException("failure while taking screenshot");
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }

    public static void takeSnapShot(WebDriver webdriver) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        ByteArrayInputStream imageAsByteArrayIS = new ByteArrayInputStream(FileUtils.readFileToByteArray(srcFile));
        Allure.addAttachment("Some Screenshot", imageAsByteArrayIS);
    }
}