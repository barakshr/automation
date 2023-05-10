package com.team.selenium;

import org.openqa.selenium.WebDriver;

public class BrowserActions {

    private final WebDriver webDriver;

    public BrowserActions() {
        this.webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
    }

    public void goToUrl(String url) throws InterruptedException {
        webDriver.navigate().to(url);
    }

    public void forward() {
        webDriver.navigate().forward();
    }

}
