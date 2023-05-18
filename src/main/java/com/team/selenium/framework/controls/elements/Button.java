package com.team.selenium.framework.controls.elements;


import com.team.selenium.framework.controls.api.ImplementedBy;

import java.time.Duration;


@ImplementedBy(ButtonImpl.class)
public interface Button extends Control {


    String getButtonText();

    void waitForButtonToBeClickable();

    void waitForButtonToBeClickable(Duration duration);
}
