package com.aiola.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProcessInitiator {

    private final static Logger logger = LogManager.getLogger(ProcessInitiator.class);

    public void openSeleniumNewBrowser(BrowserType browserType, String aut) {
        logger.debug("start new selenium test");
        WebDriverFactory webDriverFactory= new WebDriverFactory();
        WebDriver webDriver = webDriverFactory.openNewWebDriver(browserType);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriver.get(aut);
    }


    public void closeSeleniumBrowser() {
        logger.debug("end selenium test and close browser");
        DriverPool.getInstance().closeDriver(Thread.currentThread().getId());
    }
}
