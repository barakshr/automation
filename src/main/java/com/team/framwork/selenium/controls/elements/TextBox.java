package com.team.framwork.selenium.controls.elements;


import com.team.framwork.selenium.controls.api.ImplementedBy;


@ImplementedBy(TextBoxImpl.class)
public interface TextBox extends Control {

    void sendKeys(String text);



}
