package com.team.selenium_pages.pages.magento;

import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class PaymentPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//button[@class='action primary checkout']")
    WebElement placeOrderButton;


    public CheckoutSuccessPage clickOnPlaceOrder() throws InterruptedException {
        getElementWait().waitForVisibilityOf(placeOrderButton, Duration.ofSeconds(3));
        getElementWait().waitForClickable(placeOrderButton, Duration.ofSeconds(3));
        Thread.sleep(1000);
        placeOrderButton.click();
        return new CheckoutSuccessPage();
    }
}
