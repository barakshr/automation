package com.aiola.selenium.pagepbject;

import com.aiola.selenium.DriverPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private final WebDriver webDriver;

    protected BasePage() {
        this.webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        PageFactory.initElements(webDriver, this);
    }

    public String getPageUrl() {
        return webDriver.getCurrentUrl();
    }



    public WebDriver getWebDriver() {
        return webDriver;
    }

    Logger getLogger() {
        return logger;
    }
}
