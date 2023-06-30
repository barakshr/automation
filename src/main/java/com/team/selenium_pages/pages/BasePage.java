package com.team.selenium_pages.pages;

import com.team.framwork.selenium.BrowserAction;
import com.team.framwork.selenium.DriverPool;
import com.team.framwork.selenium.ElementWait;
import com.team.framwork.selenium.controls.api.ControlFactory;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public abstract class BasePage {
    private final Logger logger;
    private final WebDriver webDriver;
    private final BrowserAction browserAction;

    private final ElementWait elementWait;

    public BasePage() {
        logger = LogManager.getLogger(this.getClass());
        this.webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        ControlFactory.initElements(this.webDriver, this);
        this.browserAction = new BrowserAction();
        this.elementWait = new ElementWait();
    }

    public <T extends BasePage> T goToPage(Class<T> tPageClass) throws IllegalAccessException, InstantiationException {
        return tPageClass.newInstance();
    }

    @Step("check start page appear")
    public void checkPageUrlAppear(String pageUrl) {
        getBrowserActions().waitForUrlToAppear(pageUrl, Duration.ofSeconds(10));
    }


    public Actions getActions() {
        return new Actions(webDriver);
    }

    public Logger getLogger() {
        return logger;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public BrowserAction getBrowserActions() {
        return browserAction;
    }

    public ElementWait getElementWait() {
        return elementWait;
    }


}
