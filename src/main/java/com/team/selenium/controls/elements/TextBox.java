package com.team.selenium.controls.elements;


import com.team.selenium.controls.api.ImplementedBy;


@ImplementedBy(TextBoxImpl.class)
public interface TextBox extends Control {

    void sendKeys(String text);



}
