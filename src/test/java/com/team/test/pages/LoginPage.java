package com.team.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage extends BasePage {

    private final static Logger LOGGER = Logger.getLogger(LoginPage.class);

    @FindBy(how = How.XPATH, using = "/html/body/main/div[4]/div[1]/ul/li[1]/a")
    private WebElement wo;


    public LoginPage login(String userName, String password) {
        return this;
    }


}
