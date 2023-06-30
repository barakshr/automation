package com.team.framwork.selenium;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ImplicitlyWait {

    private final WebDriver webDriver;

    public ImplicitlyWait() {
        this.webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
    }

     void setImplicitWaits(){
         webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
         webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
         webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(3));
     }
}
