package com.team.framwork.selenium.controls.elements;

import com.team.framwork.selenium.controls.api.ImplementedBy;

@ImplementedBy(SimpleSimpleTextImpl.class)
public interface SimpleText extends Control {
    String getText();

}
