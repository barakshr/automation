package com.team.selenium_pages.pages.magento;

import com.team.framwork.selenium.controls.elements.Dropdown;
import com.team.selenium_pages.pages.BasePage;
import com.team.selenium_pages.pages.magento.enums.CheckOutTextField;
import com.team.selenium_pages.pages.magento.enums.Country;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class CheckOutPage extends BasePage {

    private final String textField = "//input[@name='%s']";


    @FindBy(how = How.XPATH, using = "//select[@name='country_id']")
    Dropdown stateDropDown;

    @FindBy(how = How.XPATH, using = "//input[@id='customer-email']")
    WebElement emailAddressTextBox;


    @FindBy(how = How.XPATH, using = "//button[@class='button action continue primary']")
    WebElement nextButton;


    @FindBy(how = How.XPATH, using = "//input[@value='flatrate_flatrate']")
    WebElement flatRateShipmentCheckBox;


    public CheckOutPage waitForPageToLoad(Duration duration) {
        getElementWait().waitForVisibilityOf(stateDropDown, duration);
        return this;
    }

    public CheckOutPage enterToTextBox(CheckOutTextField CheckOutTextField, String value) {
        String textFieldString = String.format(textField, CheckOutTextField.getValue());
        WebElement webElement = getWebDriver().findElement(By.xpath(textFieldString));
        webElement.sendKeys(value);
        return this;
    }


    public CheckOutPage enterEmailAddress(String emailAddress) {
        emailAddressTextBox.sendKeys(emailAddress);
        return this;
    }

    public CheckOutPage selectCountry(Country country) throws InterruptedException {
        getElementWait().waitForClickable(stateDropDown, Duration.ofSeconds(4));
        Thread.sleep(1000);
        stateDropDown.selectFormDropdown(country.getValue());
        return this;
    }

    public CheckOutPage setRateShipment() {
        flatRateShipmentCheckBox.click();
        return this;
    }

    public CheckOutPage clickOnNext() {
        getElementWait().waitForClickable(nextButton, Duration.ofSeconds(3));
        nextButton.click();
        return this;
    }

}
