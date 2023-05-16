package com.team.test.pages;

import com.team.selenium.controls.elements.SimpleText;
import com.team.selenium.controls.elements.TextBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StartPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(StartPage.class);

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[2]/div[2]/div/div/div[4]/div[2]/div[1]/div/div/div/input")
    private TextBox filterTxb;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[2]/div[2]/div/div/div[4]/div[2]/div[2]/div/div[3]/div/div[2]/div/h3")
    private WebElement filterTextResults;


    public StartPage filterByTitle(String filterText) {
        filterTxb.sendKeys(filterText);
        return this;
    }

    public String getFilterResults() {
        return filterTextResults.getText();
    }

}
