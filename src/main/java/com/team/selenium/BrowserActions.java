package com.team.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserActions {

    private final WebDriver webDriver;

    public BrowserActions() {
        this.webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
    }

    public void goToUrl(String url) throws InterruptedException {
        webDriver.navigate().to(url);
    }

    public void waitForUrlToAppear(String expectedUrl, Duration duration){
        WebDriverWait webDriverWait  =new WebDriverWait(webDriver, duration);
        webDriverWait.until(ExpectedConditions.urlContains(expectedUrl));
    }


    public void forward() {
        webDriver.navigate().forward();
    }

}
