package com.team.selenium.controls.elements;


import com.team.selenium.controls.api.ImplementedBy;


@ImplementedBy(ButtonImpl.class)
public interface TextBox extends Control {

     void sendKeys(String text);
     String getTextBoxTest();

}
