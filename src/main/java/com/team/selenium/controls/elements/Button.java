package com.team.selenium.controls.elements;


import com.team.selenium.controls.api.ImplementedBy;

import java.time.Duration;


@ImplementedBy(ButtonImpl.class)
public interface Button extends Control {


    String getButtonText();
    public void waitForButtonToBeClickable();
    public void waitForButtonToBeClickable(Duration duration) ;
}
