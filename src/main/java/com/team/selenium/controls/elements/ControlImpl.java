package com.team.selenium.controls.elements;


import com.team.selenium.DriverPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class ControlImpl implements Control {

    private final WebElement element;
    private final WebDriver webDriver;


    public ControlImpl(final WebElement element) {
        this.element = element;
        this.webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
    }

    @Override
    public void click() {
        element.click();
    }


    @Override
    public void waitForElementToBeVisible(int seconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Override
   public String getText(){
        return element.getText();
    }

    WebElement getElement() {
        return element;
    }

    WebDriver getWebDriver() {
        return webDriver;
    }
}
