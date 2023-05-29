package com.team.selenium_pages.pages.herokuapp;

import com.team.framwork.selenium.controls.elements.Button;
import com.team.framwork.selenium.controls.elements.SimpleText;
import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class JsAlertsPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//button[text()='Click for JS Alert']")
    private Button triggerAlertButton;

    @FindBy(how = How.ID, using = "result")
    private SimpleText alertResultMessage;


    public JsAlertsPage clickOnJsAlertButton() {
        triggerAlertButton.click();
        return this;
    }

    public String getAlertText() {
        return getWebDriver().switchTo().alert().getText();
    }

    public JsAlertsPage acceptAlert() {
        getWebDriver().switchTo().alert().accept();
        return this;
    }

    public String verifyAlertClicked() {
        return alertResultMessage.getText();
    }


}
