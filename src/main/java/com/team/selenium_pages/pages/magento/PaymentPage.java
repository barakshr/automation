package com.team.selenium_pages.pages.magento;

import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@id='checkout-payment-method-load']/div/div/div[2]/div[2]/div[4]/div")
    WebElement placeOrderButton;




    public CheckoutSuccessPage clickOnPlaceOrder() throws InterruptedException {
        getElementWait().waitForVisibilityOf(placeOrderButton, Duration.ofSeconds(3));
        getElementWait().waitForClickable(placeOrderButton,Duration.ofSeconds(3));
        Thread.sleep(1000);
        placeOrderButton.click();
        return new CheckoutSuccessPage();
    }
}
