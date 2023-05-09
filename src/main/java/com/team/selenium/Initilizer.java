package com.team.selenium;

import com.team.selenium.properties.PropertiesHandler;
import com.team.selenium.properties.Settings;

public class Initilizer {

    protected BrowserActions browserActions;

    public Initilizer() throws Exception {
        PropertiesHandler.readProperties();
        new WebDriverFactory().openNewWebDriver(Settings.BrowserType);
        BrowserActions browserActions= new BrowserActions();
        browserActions.goToUrl(Settings.AUT);
    }

    public  void closeDriver(){
        DriverPool.getInstance().closeDriver(Thread.currentThread().getId());
    }

}
