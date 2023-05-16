package com.team.test.pages;


import com.team.selenium.controls.elements.Button;
import com.team.test.Trash;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {




    @FindBy(how = How.XPATH, using = "/html/body/main/div[3]/div[1]/ul/li[1]/a")
    private Button workManagementButton;

    @FindBy(how = How.XPATH, using = "/html/body/header/div/div[1]/div/div[2]/div[4]/div/div/div/div/div[1]/div/div/div/button/span/span/div/span[1]/span")
    private Button myAccountButton;

    @FindBy(how = How.XPATH, using = "/html/body/header/div/div[1]/div/div[2]/div[4]/div/div/div/div/div[3]/div/div/div/div/div/div/div[2]/div")
    private Button loginButton;

    @Step("click on work management button")
    public HomePage clickOnWorkManagement() {
        getLogger().info("clickOnWorkManagement button");
        workManagementButton.waitForButtonToBeClickable();
        workManagementButton.click();
        return this;
    }

    @Step("go to login page")
    public LoginPage goToLoginPage() {
        myAccountButton.click();
        getLogger().info("click login button");
        loginButton.click();
        return new LoginPage();
    }

}
