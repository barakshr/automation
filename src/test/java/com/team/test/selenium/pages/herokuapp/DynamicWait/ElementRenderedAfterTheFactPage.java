package com.team.test.selenium.pages.herokuapp.DynamicWait;

import com.team.selenium.controls.elements.Button;
import com.team.selenium.controls.elements.SimpleText;
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
    SimpleText finish;

    public void press(){
      //  WebDriverWait wait=  new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));

        startButton.click();

        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf((WebElement) finish));

  //      finish.waitForElementToBeVisible(10);
      //  wait.until(ExpectedConditions.visibilityOf(finish));
        finish.getText();
    }




}
