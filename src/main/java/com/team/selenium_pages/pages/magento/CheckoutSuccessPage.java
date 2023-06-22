package com.team.selenium_pages.pages.magento;

import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutSuccessPage extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = "checkout-success")
    WebElement checkoutSuccess;

    //regex
    public String getOrderId(){
        return checkoutSuccess.getText();
    }
}
