package com.team.test.pages;

import com.team.selenium.BrowserActions;
import com.team.selenium.DriverPool;
import com.team.selenium.controls.api.ControlFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

public  abstract class  BasePage  {

     final WebDriver webDriver;

    public BasePage() {
        this.webDriver= DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        ControlFactory.initElements(this.webDriver,this);
    }


    public <T extends BasePage> T goToPage(Class<T> tPageClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return tPageClass.getConstructor(WebDriver.class).newInstance(this.webDriver);
    }




}
