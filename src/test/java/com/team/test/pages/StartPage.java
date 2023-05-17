package com.team.test.pages;

import com.team.selenium.controls.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class StartPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//input[@data-testid='recent-work_search-input']")
    private TextBox filterTxb;

    @FindBy(how = How.XPATH, using = "//div[@data-testid='viewedPanel']")
    private WebElement filterTextResults;


    public StartPage filterByTitle(String filterText) {
        filterTxb.sendKeys(filterText);
        return this;
    }

    public String getFilterResults() {
        return filterTextResults.getText();
    }

}
