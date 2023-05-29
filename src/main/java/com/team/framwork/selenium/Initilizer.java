package com.team.framwork.selenium;

import com.team.framwork.selenium.properties.PropertiesHandler;
import com.team.framwork.selenium.properties.Settings;

public class Initilizer {

    public Initilizer() throws Exception {
        PropertiesHandler.readProperties();
        new WebDriverFactory().openNewWebDriver(Settings.BrowserType);
        BrowserActions browserActions = new BrowserActions();
        browserActions.maximize();
        browserActions.goToUrl(Settings.AUT);
    }

    public void closeDriver() {
        DriverPool.getInstance().closeDriver(Thread.currentThread().getId());
    }

}
