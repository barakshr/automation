package com.aiola.selenium.pagepbject.bankproject;

public class WithdrawPage extends TransactionsOperations<WithdrawPage> {



    @Override
    public WithdrawPage enterAmountToTextBox(int amount) throws InterruptedException {

        String amountStr = Integer.toString(amount);
        amountTextBox.sendKeys(amountStr);
        Thread.sleep(100);
        return this;
    }

    @Override
    public WithdrawPage clickOnSubmitAmountButton() throws InterruptedException {
        submitButton.click();
        Thread.sleep(400);
        return this;
    }
}
