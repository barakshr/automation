package com.team.selenium.framework.controls.elements;


import com.team.selenium.framework.controls.api.ImplementedBy;


@ImplementedBy(TextBoxImpl.class)
public interface TextBox extends Control {

    void sendKeys(String text);

    String getTextBoxTest();

}
