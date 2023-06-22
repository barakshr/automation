package com.team.selenium_pages.pages.magento;

import com.team.framwork.selenium.controls.elements.Dropdown;
import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CheckOutPage extends BasePage {

    //fix
    @FindBy(how = How.XPATH ,using = "//select[@class='select']")
    List<Dropdown> countryDropDown;

    @FindBy(how = How.XPATH, using = "//input[@id='customer-email']")
    WebElement emailAddressTextBox;

    @FindBy(how = How.XPATH, using = "//input[@name='firstname']")
    WebElement firstNameTextBox;

    @FindBy(how = How.XPATH, using = "//input[@name='lastname']")
    WebElement lastNameTextBox;

    @FindBy(how = How.XPATH, using = "//input[@name='company']")
    WebElement companyTextBox;

    @FindBy(how = How.XPATH, using = "//input[@name='city']")
    WebElement cityTextBox;

    @FindBy(how = How.XPATH, using = "//input[@name='telephone']")
    WebElement phoneNumberTextBox;

    @FindBy(how = How.XPATH, using = "//input[@name='postcode']")
    WebElement zipCodeTextBox;

    @FindBy(how = How.XPATH, using = "//input[@name='street[0]']")
    WebElement streetFirstTextBox;

    @FindBy(how = How.XPATH, using = "//button[@class='button action continue primary']")
    WebElement nextButton;

    //button[@class='button action continue primary']

    public CheckOutPage enterEmailAddress(String emailAddress) {
        emailAddressTextBox.sendKeys(emailAddress);
        return this;
    }

    public CheckOutPage enterFirstName(String firstName) {
        firstNameTextBox.sendKeys(firstName);
        return this;
    }


    public CheckOutPage enterLastName(String lastName) {
        lastNameTextBox.sendKeys(lastName);
        return this;
    }

    public CheckOutPage enterCompanyName(String companyName) {
        companyTextBox.sendKeys(companyName);
        return this;
    }


    public CheckOutPage enterCity(String cityName) {
        cityTextBox.sendKeys(cityName);
        return this;
    }


    public CheckOutPage enterPhoneNumber(String phoneNumber) {
        phoneNumberTextBox.sendKeys(phoneNumber);
        return this;
    }

    public CheckOutPage enterZipCode(String zipCode) {
        zipCodeTextBox.sendKeys(zipCode);
        return this;
    }

    public CheckOutPage enterStreetFirstTextBox(String street) {
        streetFirstTextBox.sendKeys(street);
        return this;
    }

    public CheckOutPage selectCountry(String country){
        countryDropDown.get(1).click();
        countryDropDown.get(1).sendKeys("Israel");
        countryDropDown.get(1).click();
        return this;
    }

    //change return class to generic
    public PaymentPage clickOnNext(){
        nextButton.click();
        return new PaymentPage();
    }

}
