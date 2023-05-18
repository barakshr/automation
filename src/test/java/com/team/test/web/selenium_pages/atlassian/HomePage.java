package com.team.test.web.selenium_pages.atlassian;


import com.team.selenium.controls.elements.Button;
import com.team.test.web.selenium_pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[@data-label='Work Management']")
    private Button workManagementButton;

    @FindBy(how =  How.CLASS_NAME, using = "css-q68uj")
    private Button myAccountButton;

    @FindBy(how = How.XPATH, using = "//div[@id='uid1']/div/div/div/div")
    private Button loginButton;

    @Step("click on work management button")
    public WorkManagementPage goToWorkManagement() {
        getLogger().info("clickOnWorkManagement button");
        workManagementButton.waitForButtonToBeClickable();
        workManagementButton.click();
        return new WorkManagementPage();
    }

    @Step("go to login page")
    public LoginPage goToLoginPage() {
        myAccountButton.click();
        getLogger().info("click login button");
        loginButton.click();
        return new LoginPage();
    }

}
