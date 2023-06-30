package com.team.framwork.selenium;

import com.team.framwork.selenium.properties.PropertiesHandler;
import com.team.framwork.selenium.properties.Settings;

public class DriverHandler {

    public DriverHandler() {
    }

    public void startSeleniumDriverProcess() throws Exception {
        PropertiesHandler.readProperties();
        new WebDriverFactory().openNewWebDriver(Settings.BrowserType);
        ImplicitlyWait implicitlyWait= new ImplicitlyWait();
        implicitlyWait.setImplicitWaits();
        CdpRegistration cdpRegistration = new CdpRegistration();
        cdpRegistration.browserLogsRegistration();
        BrowserAction browserAction = new BrowserAction();
        browserAction.maximize();
        browserAction.goToUrl(Settings.AUT);
    }

    public void closeSeleniumDriver() {
        DriverPool.getInstance().closeDriver(Thread.currentThread().getId());
    }

}
