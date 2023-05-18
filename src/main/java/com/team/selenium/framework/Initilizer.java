package com.team.selenium.framework;

import com.team.selenium.framework.properties.PropertiesHandler;
import com.team.selenium.framework.properties.Settings;

public class Initilizer {

    public Initilizer() throws Exception {
        PropertiesHandler.readProperties();
        new WebDriverFactory().openNewWebDriver(Settings.BrowserType);
        BrowserActions browserActions = new BrowserActions();
        browserActions.goToUrl(Settings.AUT);
    }

    public void closeDriver() {
        DriverPool.getInstance().closeDriver(Thread.currentThread().getId());
    }

}
