package com.aiola.selenium.pagepbject.bankproject;

import com.aiola.selenium.pagepbject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TransactionsPage extends BasePage {


    //todo/
    ///change to css
    // @FindBy(how = How.XPATH, using = "table[@class='table table-bordered table-striped']/tbody/tr")
    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[2]/table/tbody/tr")
    List<WebElement> tableTransactions;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[1]/button[1]")
    WebElement backButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[1]/button[2]")
    WebElement resetButton;


    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[3]/button[3]")
    WebElement nextPageButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[3]/button[1]")
    WebElement backPageButton;


    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[3]/button[2]")
    WebElement topButton;


    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div/div[2]/table/thead/tr/td[1]/a")
    WebElement dateTimeColumnLabel;

    public AccountPage pressOnBackButton() {
        backButton.click();
        return new AccountPage();
    }


    public String getDateTimeFromLine(int lineNumber) {
        return getTextFromLineAndColumn(--lineNumber, 1);
    }

    public String getAmountOfFromLine(int lineNumber) {
        return getTextFromLineAndColumn(--lineNumber, 2);
    }

    public String getTransactionTypeFromLine(int lineNumber) {
        return getTextFromLineAndColumn(--lineNumber, 3);
    }


    private String getTextFromLineAndColumn(int lineIndex, int columnIndex) {
        String path = String.format("//tr[@id='anchor%s']/td[%s]", lineIndex, columnIndex);
        return getWebDriver()
                .findElement(By.xpath(path)).getText();
    }

    public TransactionsPage clickOnResetButton() {
        resetButton.click();
        return this;
    }

    @Override
    public String getPageUrl() {
        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(2));
        webDriverWait.until(ExpectedConditions.visibilityOf(backButton));
        return super.getPageUrl();
    }

    public int getNumberOfTransactionInTable() {
        return tableTransactions.size();
    }

    public TransactionsPage refreshPage(int numberOfTimes) {
        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(2));
        webDriverWait.until(ExpectedConditions.visibilityOf(backButton));
        for (int i = 0; i < numberOfTimes; i++) {
            getWebDriver().navigate().refresh();
        }
        return this;
    }


    public TransactionsPage clickOnNextPageButton(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            nextPageButton.click();
        }
        return this;
    }

    public TransactionsPage clickOnBackPageButton(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            backPageButton.click();
        }
        return this;
    }

    public TransactionsPage clickOnTopButton() throws InterruptedException {
        Thread.sleep(100);
        topButton.click();
        return this;
    }

    public Boolean isDateTimeColumnLabelDisplayed() {
        return dateTimeColumnLabel.isDisplayed();
    }

}
