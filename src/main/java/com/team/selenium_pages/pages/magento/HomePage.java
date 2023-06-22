package com.team.selenium_pages.pages.magento;

import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[@id='ui-id-6']")
    WebElement gear;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/div/div[2]/nav/ul/li[4]/ul/li[1]/a/span")
    WebElement bags;

    public HomePage hoverOnGear() {
        getActions().moveToElement(gear).perform();
        return this;
    }

    public BagsPage enterBagsOption() {
        bags.click();
        return new BagsPage();
    }
}