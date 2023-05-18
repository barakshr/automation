package com.team.selenium.framework.controls.elements;

import com.team.selenium.framework.controls.api.ImplementedBy;

@ImplementedBy(SimpleSimpleTextImpl.class)
public interface SimpleText extends Control {
    String getText();

}
