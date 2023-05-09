package com.team.selenium.controls.elements;


import com.team.selenium.controls.api.ImplementedBy;
import org.openqa.selenium.WebElement;

/**
 * Created by Karthik-pc on 12/10/2018.
 */
//public class ButtonBase extends ControlBase {

@ImplementedBy(ButtonImpl.class)
public class ButtonImpl extends ControlImpl implements Button {

    public ButtonImpl(WebElement element) {
        super(element);
    }


    @Override
    public String getButtonText() {
        return getElement().getText();
    }
}
