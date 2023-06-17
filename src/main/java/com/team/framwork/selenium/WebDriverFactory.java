package com.team.framwork.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class WebDriverFactory {

    private final static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public static void openNewWebDriver(BrowserType browserType) throws Exception {
        String path = System.getProperty("user.dir") + "/src/main/resources/drivers/";
        WebDriver webDriver = null;
        switch (browserType) {
            case Firefox:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case Chrome:
                /*
                fix selenium bug , 500 error in the response, when using this lib :
                   WebDriverManager.chromedriver().setup();
                   webDriver = new ChromeDriver();
                   webDriver.get("www.cnn.com");
                */
                System.setProperty("webdriver.chrome.driver", path + "chromedriver");
                ChromeDriver chromeDriver = new ChromeDriver();
                cdpLogs(chromeDriver.getDevTools());
                webDriver = chromeDriver;
                break;

            case IE:
                throw new Exception("IE not web driver implemented");
        }
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(3));
        DriverPool.getInstance().setDriver(Thread.currentThread().getId(), webDriver);
    }

    //devTools only available for chrome and edge
    private static void cdpLogs(DevTools devTools) {
        devTools.createSession();
        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(), logEntry -> {
            logger.info("--------Browser Console Log Start-------");
            logger.info("Level: " + logEntry.getLevel());
            logger.info("Text: " + logEntry.getText());
            logger.info("Broken URL: " + logEntry.getUrl());
            logger.info("--------Browser Console Log End---------");
        });
    }
}
