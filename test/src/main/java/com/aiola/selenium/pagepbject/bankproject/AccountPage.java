package com.aiola.selenium.pagepbject.bankproject;

import com.aiola.selenium.pagepbject.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage extends BasePage {

    @FindBy(how = How.CSS, using = "button[ng-click='transactions()']")
    WebElement transactionButton;

    @FindBy(how = How.CSS, using = "button[ng-click='deposit()']")
    WebElement depositButton;

    @FindBy(how = How.CSS, using = "button[ng-click='withdrawl()']")
    WebElement withdrawButton;




    public TransactionsPage clickOnTransactionButton(){
        transactionButton.click();
        return new TransactionsPage();
    }

    public DepositPage clickOnDepositButton(){
        depositButton.click();
        return new DepositPage();
    }

    public WithdrawPage clickOnWithdrawButton(){
        withdrawButton.click();
        return new WithdrawPage();
    }

}
