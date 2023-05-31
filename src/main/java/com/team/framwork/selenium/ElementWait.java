package com.team.framwork.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementWait {
   private final WebDriver webDriver;

    public ElementWait(){
        this.webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
    }

    public void waitForVisibilityOf(WebElement element,Duration duration){
        WebDriverWait wait = new WebDriverWait(webDriver, duration);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
