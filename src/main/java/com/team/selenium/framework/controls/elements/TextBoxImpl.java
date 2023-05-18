package com.team.selenium.framework.controls.elements;


import com.team.selenium.framework.controls.api.ImplementedBy;
import org.openqa.selenium.WebElement;

@ImplementedBy(TextBoxImpl.class)
public class TextBoxImpl extends ControlImpl implements TextBox {

    public TextBoxImpl(WebElement element) {
        super(element);
    }

    @Override
    public void sendKeys(String text) {
        getElement().sendKeys(text);

    }

    @Override
    public String getTextBoxTest() {
        return getElement().getText();
    }
}
