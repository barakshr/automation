package com.team.selenium_pages.pages.magento;

import com.team.framwork.selenium.ElementWait;
import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;
import java.util.List;

public class BagsPage extends BasePage {
    private Integer numberOfItemsInCart = 0;

    @FindBy(how = How.XPATH, using = "//li[@class='item product product-item']")
    List<WebElement> bags;

    //button?
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/header/div[2]/div[1]/a/span[2]/span[1]")
    WebElement cartCounter;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/header/div[2]/div[1]/a")
    WebElement cartIconButton;

    @FindBy(how = How.ID, using = "top-cart-btn-checkout")
    WebElement checkOutButton;

    public BagsPage addBagToCart(int itemNumber) throws Exception {
        if (itemNumber > bags.size() + 1) {
            throw new Exception(String.format("item number %s doesnt exist in page", itemNumber));
        }
        WebElement bag = bags.get(itemNumber);
        getActions().moveToElement(bag).perform();
        Item item = new Item(bag);
        item.addToCart();
        //bug when item index is more than 1
        ElementWait elementWait = new ElementWait();
        numberOfItemsInCart++;
        elementWait.waitForText(cartCounter, Duration.ofSeconds(5), numberOfItemsInCart.toString());
        return this;
    }

    public CheckOutPage goToCheckout() {
        getActions().moveToElement(cartIconButton).click().perform();
        checkOutButton.click();
        return new CheckOutPage();
    }
}
