package com.team.selenium.controls.elements;


import com.team.selenium.controls.api.ImplementedBy;


@ImplementedBy(ButtonImpl.class)
public interface Button extends Control {


    String getButtonText();

}
