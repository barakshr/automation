package com.team.test.pages;


import com.team.selenium.controls.elements.Button;
import com.team.selenium.controls.elements.TextBox;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {


    @FindBy(how = How.XPATH, using = "/html/body/main/div[3]/div[1]/ul/li[1]/a")
    private Button workManagementButton;


    @FindBy(how = How.XPATH, using = "/html/body/main/div[3]/div[1]/ul/li[2]/a")
    private Button itButton;


    public HomePage clickOnWorkManagement() {
        workManagementButton.getButtonText();
        return this;
    }

    public HomePage clickOnIt() {
        itButton.click();
        return this;
    }
}
