package com.team.selenium_pages.pages.atlassian;

import com.team.framwork.selenium.controls.elements.Control;
import com.team.selenium_pages.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;


public class LoginPage extends BasePage {


    @FindBy(how = How.ID, using = "login-submit")
    private Control continueBtn;

    @FindBy(how = How.ID, using = "login-submit")
    private Control loginBtn;

    @FindBy(how = How.ID, using = "username")
    private Control emailAddressTxb;

    @FindBy(how = How.ID, using = "password")
    private Control passwordTxb;

    @FindBy(how = How.CLASS_NAME, using = "css-xal9c7")
    private WebElement wrongPasswordError;


    @Step("login page")
    public LoginPage login(String userName, String password) {
        emailAddressTxb.waitForElementToBeVisible(Duration.ofSeconds(10));
        emailAddressTxb.sendKeys(userName);
        continueBtn.click();
        passwordTxb.waitForElementToBeVisible(Duration.ofSeconds(10));
        passwordTxb.sendKeys(password);
        loginBtn.click();
        return this;
    }


    @Step("login failure message")
    public String getLoginFailure() {
        return wrongPasswordError.getText();
    }
}
