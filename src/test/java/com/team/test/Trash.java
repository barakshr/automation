package com.team.test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Trash {

    private static final Logger LOGGER = LoggerFactory.getLogger(Trash.class.getName());

    @Test
    public void fffaaa() throws InterruptedException {
        LOGGER.info("selenium test");
        System.setProperty("webdriver.gecko.driver","/Users/barakshamir/Documents/temp/geckodriver"); // Setting system properties of FirefoxDriver
        WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
        driver.get("https://www.google.com/");
        driver.close();
    }
}
