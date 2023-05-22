package com.team.test.selenium.pages.herokuapp.DynamicWait;

import com.team.test.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementRenderedAfterTheFactPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@id='start']/button")
    WebElement startButton;

    @FindBy(how = How.ID, using = "finish")
    WebElement finish;

    public void press() {
        startButton.click();
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(finish));
        finish.getText();
    }


}
