package com.team.test.pages.atlassian;

import com.team.selenium.controls.elements.Button;
import com.team.selenium.controls.elements.SimpleText;
import com.team.selenium.controls.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage extends BasePage {


    @FindBy(how = How.ID, using = "login-submit")
    private Button continueBtn;

    @FindBy(how = How.ID, using = "login-submit")
    private Button loginBtn;

    @FindBy(how = How.ID, using = "username")
    private TextBox emailAddressTxb;

    @FindBy(how = How.ID, using = "password")
    private TextBox passwordTxb;

    @FindBy(how = How.CLASS_NAME, using = "css-xal9c7")
    private SimpleText wrongPasswordError;


    @Step("login page")
    public LoginPage login(String userName, String password) {
        emailAddressTxb.waitForElementToBeVisible(5000);
        emailAddressTxb.sendKeys(userName);
        continueBtn.click();
        passwordTxb.waitForElementToBeVisible(5000);
        passwordTxb.sendKeys(password);
        loginBtn.click();
        return this;
    }


    @Step("login failure message")
    public String getLoginFailure() {
        return wrongPasswordError.getText();
    }
}
