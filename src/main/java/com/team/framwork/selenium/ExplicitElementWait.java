package com.team.framwork.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitElementWait {
    private final WebDriver webDriver;

    public ExplicitElementWait() {
        this.webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
    }

    public void waitForVisibilityOf(WebElement element, Duration duration) {
        WebDriverWait wait = new WebDriverWait(webDriver, duration);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForText(WebElement element, Duration duration, String text) {
        WebDriverWait wait = new WebDriverWait(webDriver, duration);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForClickable(WebElement element, Duration duration) {
        WebDriverWait wait = new WebDriverWait(webDriver, duration);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
