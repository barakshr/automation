package com.aiola.selenium.pagepbject.bankproject;

import com.aiola.selenium.pagepbject.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how = How.CSS, using = "button[ng-click='customer()']")
    WebElement customerLoginButton;


    public CustomerPage clickOnCustomerLoginButton() {
        customerLoginButton.click();
        return new CustomerPage();
    }

}
