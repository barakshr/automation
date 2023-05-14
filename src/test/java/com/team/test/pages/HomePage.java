package com.team.test.pages;


import com.team.selenium.controls.elements.Button;
import com.team.test.Testing;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {


    private static final Logger LOGGER =  LogManager.getLogger(Testing.class);

    @FindBy(how = How.XPATH, using = "/html/body/main/div[3]/div[1]/ul/li[1]/a")
    private Button workManagementButton;


    @FindBy(how = How.XPATH, using = "/html/body/main/div[3]/div[1]/ul/li[2]/a")
    private Button itButton;


    @Step("clickOnWorkManagement button")
    public HomePage clickOnWorkManagement() {
        LOGGER.info("clickOnWorkManagement button");
        workManagementButton.click();
        return this;
    }

    public HomePage clickOnIt() {
        itButton.click();
        return this;
    }
}
