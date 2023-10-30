package com.aiola.selenium.pagepbject.bankproject;

import com.aiola.selenium.pagepbject.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class TransactionsOperations<T extends TransactionsOperations> extends BasePage {

    @FindBy(how = How.CSS, using = "button[ng-click='deposit()']")
    WebElement depositButton;

    @FindBy(how = How.CSS, using = "input[type='number']")
    WebElement amountTextBox;

    @FindBy(how = How.CSS, using = "button[type='submit']")
    WebElement submitButton;

    @FindBy(how = How.CSS, using = "button[ng-click='transactions()']")
    WebElement transactionButton;

    @FindBy(how = How.CSS, using = "button[ng-click='withdrawl()']")
    WebElement withdrawButton;


    public abstract T enterAmountToTextBox(int amount) throws InterruptedException;

    public abstract T clickOnSubmitAmountButton() throws InterruptedException;


    public TransactionsPage clickOnTransactionButton() throws InterruptedException {
        Thread.sleep(500);
        transactionButton.click();
        Thread.sleep(500);
        return new TransactionsPage();
    }

    public WithdrawPage clickOnWithdrawButton() throws InterruptedException {
        Thread.sleep(500);
        withdrawButton.click();
        Thread.sleep(500);
        return new WithdrawPage();
    }

    public DepositPage clickOnDepositButton() {
        depositButton.click();
        return new DepositPage();
    }

}
