package com.aiola.selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.util.HashMap;
import java.util.Map;


public class WebDriverFactory {

    private final static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    WebDriver openNewWebDriver(BrowserType browserType) {
        WebDriver webDriver = null;
        switch (browserType) {
            case Firefox:
                logger.info("opening new firefox web driver");
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case Chrome:
                logger.info("opening new chrome web driver");
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
        }
        webDriver.manage().window().maximize();
        DriverPool.getInstance().setDriver(Thread.currentThread().getId(), webDriver);
        return webDriver;
    }


}
