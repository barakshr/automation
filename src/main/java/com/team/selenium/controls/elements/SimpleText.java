package com.team.selenium.controls.elements;

import com.team.selenium.controls.api.ImplementedBy;

@ImplementedBy(SimpleSimpleTextImpl.class)
public interface SimpleText extends Control {
    String getText();

}
