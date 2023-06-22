package com.team.selenium_pages.pages.magento;

import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//button[@class='action primary checkout']")
    WebElement placeOrderButton;

    public CheckoutSuccessPage clickOnPlaceOrder(){
        placeOrderButton.click();
        return new CheckoutSuccessPage();
    }
}
