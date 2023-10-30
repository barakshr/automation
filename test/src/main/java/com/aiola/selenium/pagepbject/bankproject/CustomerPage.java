package com.aiola.selenium.pagepbject.bankproject;

import com.aiola.selenium.pagepbject.BasePage;
import com.aiola.selenium.pagepbject.bankproject.enums.CustomerName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage extends BasePage {

    @FindBy(how = How.ID, using = "userSelect")
    WebElement nameDropDown;

    @FindBy(how = How.CSS, using = "button[class='btn btn-default']")
    WebElement loginButton;


    public CustomerPage selectNameFromDropDown(CustomerName customerName) {
        Select nameDropDownElementSelect = new Select(nameDropDown);
        nameDropDownElementSelect.selectByVisibleText(customerName.getName());
        return this;
    }


    public AccountPage clickOnLoginButton() {
        loginButton.click();
        return new AccountPage();
    }


}
