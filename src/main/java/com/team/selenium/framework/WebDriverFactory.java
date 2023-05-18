package com.team.selenium.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class WebDriverFactory {


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
                webDriver = new ChromeDriver();
                break;

            case IE:
                throw new Exception("IE not web driver implemented");
        }

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        DriverPool.getInstance().setDriver(Thread.currentThread().getId(), webDriver);
    }
}
