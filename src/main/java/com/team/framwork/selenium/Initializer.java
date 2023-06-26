package com.team.framwork.selenium;

import com.team.framwork.selenium.properties.PropertiesHandler;
import com.team.framwork.selenium.properties.Settings;
import org.openqa.selenium.WebDriver;

public class Initializer {

    public Initializer() throws Exception {
        PropertiesHandler.readProperties();
       new WebDriverFactory().openNewWebDriver(Settings.BrowserType);
        BrowserAction browserAction = new BrowserAction();
        CdpRegistration cdpRegistration= new CdpRegistration();
        cdpRegistration.browserLogsRegistration();
        browserAction.maximize();
        browserAction.goToUrl(Settings.AUT);
    }

    public void closeDriver() {
        DriverPool.getInstance().closeDriver(Thread.currentThread().getId());
    }

}
