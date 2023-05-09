package com.team.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitImpl implements Wait {

private  final WebDriver webDriver;

    public WaitImpl(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
}
