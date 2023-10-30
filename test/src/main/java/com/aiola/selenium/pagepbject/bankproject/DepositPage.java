package com.aiola.selenium.pagepbject.bankproject;

public class DepositPage extends TransactionsOperations<DepositPage> {


    @Override
    public DepositPage enterAmountToTextBox(int amount) throws InterruptedException {
        String amountStr = Integer.toString(amount);
        amountTextBox.sendKeys(amountStr);
        Thread.sleep(100);
        return this;
    }

    @Override
    public DepositPage clickOnSubmitAmountButton() throws InterruptedException {
        submitButton.click();
        Thread.sleep(100);
        return this;
    }


}
