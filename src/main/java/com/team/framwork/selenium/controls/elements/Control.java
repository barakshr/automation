package com.team.framwork.selenium.controls.elements;


import com.team.framwork.selenium.controls.api.ImplementedBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;

import java.time.Duration;

@ImplementedBy(ControlImpl.class)
public interface Control  extends WebElement, WrapsElement, Locatable {

    void waitForElementToBeVisible(Duration duration);

    void click();

    String getText();

}
