package com.team.test.pages;

import com.team.selenium.controls.elements.Button;
import com.team.selenium.controls.elements.SimpleText;
import com.team.selenium.controls.elements.TextBox;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;


public class LoginPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(BasePage.class);


    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/section/div[2]/form/button/span")
    private Button continueBtn;


    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/section/div[2]/form/button/span/span")
    private Button loginBtn;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/section/div[2]/form/div[1]/div[1]/div/div/div/input")
    private TextBox emailAddressTxb;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/section/div[2]/form/div[1]/div[2]/div/div/div/div/div/input")
    private TextBox passwordTxb;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/section/div[2]/div/section/div/div[2]/span/span")
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

    @Step("check start page appear")
    public void checkStartPageAppear() {
        getBrowserActions().waitForUrlToAppear("start.atlassian.com", Duration.ofSeconds(10));
    }

    @Step("login failure message")
    public String getLoginFailure() {
        return wrongPasswordError.getText();
    }
}
