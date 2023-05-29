package com.team.selenium_pages.pages.herokuapp;

import com.team.framwork.selenium.controls.elements.TextBox;
import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class KeyPressesPage  extends BasePage {

    @FindBy(how = How.ID, using = "target")
    TextBox textBox;

   public KeyPressesPage enterText(String keys){
        textBox.sendKeys(keys);
        return this;
    }

    public String getTextInTextBox(){
       return textBox.getText();
    }
}
