package com.team.experimentstests;

import com.team.framwork.selenium.BrowserType;
import com.team.framwork.selenium.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseExperiment {

    private ChromeDriver webDriver;

    @BeforeMethod
    public void setUp() throws Exception {
        WebDriverFactory.openNewWebDriver(BrowserType.Chrome);
        this.webDriver = WebDriverFactory.tempDriver;
    }

    public ChromeDriver getWebDriver() {
        return webDriver;
    }

    @AfterMethod
    public void tearDown() {
        webDriver.close();
    }
}
