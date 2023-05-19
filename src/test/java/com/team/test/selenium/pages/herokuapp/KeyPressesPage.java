package com.team.test.selenium.pages.herokuapp;

import com.team.selenium.controls.elements.Button;
import com.team.selenium.controls.elements.TextBox;
import com.team.test.selenium.pages.BasePage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;


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
