package com.team.framwork.selenium;

import com.team.framwork.selenium.properties.PropertiesHandler;
import com.team.framwork.selenium.properties.Settings;

public class Initilizer {

    public Initilizer() throws Exception {
        PropertiesHandler.readProperties();
        new WebDriverFactory().openNewWebDriver(Settings.BrowserType);
        BrowserAction browserAction = new BrowserAction();
        browserAction.maximize();
        browserAction.goToUrl(Settings.AUT);
    }

    public void closeDriver() {
        DriverPool.getInstance().closeDriver(Thread.currentThread().getId());
    }

}
