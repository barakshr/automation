package com.team.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;


public class WebDriverFactory {

    public static void  openNewWebDriver(BrowserType browserType) throws Exception {
        WebDriver webDriver = null;
        switch (browserType) {
            case Firefox:
                System.setProperty("webdriver.gecko.driver", "/Users/barakshamir/Documents/automation_new/automation/geckodriver");
                webDriver = new FirefoxDriver();
                break;
            case Chrome:
                ChromeOptions chromeOptions = new ChromeOptions();
                webDriver = new RemoteWebDriver(new URL("http://192.168.0.207:4444"), chromeOptions);
                break;

            case IE:
                webDriver = new InternetExplorerDriver();
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        DriverPool.getInstance().setDriver(Thread.currentThread().getId(), webDriver);
    }
}
