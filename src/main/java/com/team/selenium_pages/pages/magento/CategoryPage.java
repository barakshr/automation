package com.team.selenium_pages.pages.magento;

import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;
import java.util.List;

public class CategoryPage extends BasePage {
    private Integer numberOfItemsInCart = 0;

    @FindBy(how = How.XPATH, using = "//li[@class='item product product-item']")
    List<WebElement> itemsInPage;

    @FindBy(how = How.CLASS_NAME, using = "counter-number")
    WebElement cartCounter;

    @FindBy(how = How.XPATH, using = "//a[@class='action showcart']")
    WebElement cartIconButton;

    @FindBy(how = How.ID, using = "top-cart-btn-checkout")
    WebElement checkOutButton;

    public CategoryPage addItemToCart(int itemNumber) throws Exception {
        if (itemNumber > itemsInPage.size() + 1) {
            throw new Exception(String.format("item number %s doesnt exist in page", itemNumber));
        }
        WebElement pageItem = itemsInPage.get(itemNumber);
        getActions().moveToElement(pageItem).perform();
        Item item = new Item(pageItem);
        item.addToCart();
        //bug when item index is more than 1
        numberOfItemsInCart++;
        getElementWait().waitForText(cartCounter, Duration.ofSeconds(5), numberOfItemsInCart.toString());
        return this;
    }

    public CheckOutPage goToCheckoutPage() {
        cartIconButton.click();
        checkOutButton.click();
        return new CheckOutPage();
    }
}
