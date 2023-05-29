package com.team.framwork.selenium.controls.elements;


import com.team.framwork.selenium.controls.api.ImplementedBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@ImplementedBy(ButtonImpl.class)
public class ButtonImpl extends ControlImpl implements Button {

    public ButtonImpl(WebElement element) {
        super(element);
    }

    @Override
    public void waitForButtonToBeClickable() {
        waitForButtonToBeClickable(Duration.ofSeconds(10));
    }

    @Override
    public void waitForButtonToBeClickable(Duration duration) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), duration);
        wait.until(ExpectedConditions.visibilityOf(getElement()));
    }

    @Override
    public String getButtonText() {
        return getElement().getText();
    }
}
