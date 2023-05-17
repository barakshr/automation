package com.team.test.pages;

import com.team.selenium.BrowserActions;
import com.team.selenium.DriverPool;
import com.team.selenium.controls.api.ControlFactory;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

public abstract class BasePage {
    private final Logger logger;
    private final WebDriver webDriver;
    private final BrowserActions browserActions;

    public BasePage() {
        logger = LogManager.getLogger(this.getClass());
        this.webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        ControlFactory.initElements(this.webDriver, this);
        this.browserActions = new BrowserActions();
    }

    public <T extends BasePage> T goToPage(Class<T> tPageClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return tPageClass.newInstance();
    }

    @Step("check start page appear")
    public void checkPageAppear(String pageUrl) {
        getBrowserActions().waitForUrlToAppear(pageUrl, Duration.ofSeconds(10));
    }

    public Logger getLogger() {
        return logger;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public BrowserActions getBrowserActions() {
        return browserActions;
    }
}
