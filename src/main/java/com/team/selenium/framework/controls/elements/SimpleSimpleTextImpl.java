package com.team.selenium.framework.controls.elements;

import org.openqa.selenium.WebElement;

public class SimpleSimpleTextImpl extends ControlImpl implements SimpleText {

    public SimpleSimpleTextImpl(WebElement element) {
        super(element);
    }

    @Override
    public String getText() {
        return getElement().getText();
    }
}
