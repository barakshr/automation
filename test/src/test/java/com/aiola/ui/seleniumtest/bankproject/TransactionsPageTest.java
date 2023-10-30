package com.aiola.ui.seleniumtest.bankproject;

import com.aiola.selenium.pagepbject.bankproject.*;
import com.aiola.selenium.pagepbject.bankproject.enums.CustomerName;
import com.google.common.collect.ImmutableList;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransactionsPageTest extends BaseTest {

    @Test
    public void transactionsPageIsAvailableTest() {
        String actualPageUrl = getAccountPage()
                .clickOnTransactionButton()
                .getPageUrl();
        String partOfExpectedPageUrl = "#/listTx";

        Assert.assertTrue(actualPageUrl.contains(partOfExpectedPageUrl));
    }

    @Test
    public void transactionsTableIsEmptyAfterLoginTest() {
        int numberOfTransactionsActualResult = getAccountPage()
                .clickOnTransactionButton()
                .getNumberOfTransactionInTable();
        Assert.assertEquals(numberOfTransactionsActualResult, 0);
    }

    @Test
    public void transactionsTableNumberOfItemsTest() throws InterruptedException {
        TransactionsPage transactionsPage = depositAndWithdrawFromTransaction(100, 20);
        int numberOfTransactionsActualResult = transactionsPage.getNumberOfTransactionInTable();
        Assert.assertEquals(numberOfTransactionsActualResult, 2);
    }

    @Test
    public void transactionsTableManyItemsTest() throws InterruptedException {
        DepositPage depositPage = getAccountPage().clickOnDepositButton();
        depositToAccount(depositPage, ImmutableList.of(100, 2, 3, 4, 5, 6, 7, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 2, 3, 4, 56, 67, 7, 7, 6, 200));
        int numberOfTransactionsActualResult = depositPage.
                clickOnTransactionButton()
                .getNumberOfTransactionInTable();
        Assert.assertEquals(numberOfTransactionsActualResult, 32);
    }

    @Test
    public void dataTimeFormatTransactionTableAfterDepositTest() throws InterruptedException {
        TransactionsPage transactionsPage = getAccountPage()
                .clickOnDepositButton()
                .enterAmountToTextBox(100)
                .clickOnSubmitAmountButton()
                .clickOnTransactionButton();

        String actualTime = transactionsPage
                .refreshPage(1)
                .getDateTimeFromLine(1);

        Pattern pattern = Pattern.compile("(Oct|Dec|Nov) [0-9][0-9]. 202[3-9] [0-9]:[0-9][0-9]:[1-9][0-9] (PM|AM)");
        Matcher matcher = pattern.matcher(actualTime);
        Assert.assertTrue(matcher.matches());
    }

    @Test
    public void amountInTransactionTableAfterDepositTest() throws InterruptedException {
        TransactionsPage transactionsPage = getAccountPage()
                .clickOnDepositButton()
                .enterAmountToTextBox(100)
                .clickOnSubmitAmountButton()
                .clickOnTransactionButton();

        String actualAmount = transactionsPage
                .refreshPage(1)
                .getAmountOfFromLine(1);
        Assert.assertEquals(actualAmount, "100");
    }

    @Test
    public void transactionTypeTransactionTableAfterDepositTest() throws InterruptedException {
        TransactionsPage transactionsPage = getAccountPage()
                .clickOnDepositButton()
                .enterAmountToTextBox(100)
                .clickOnSubmitAmountButton()
                .clickOnTransactionButton();

        String actualAmount = transactionsPage
                .refreshPage(1)
                .getTransactionTypeFromLine(1);
        Assert.assertEquals(actualAmount, "Credit");
    }

    @Test
    public void amountInTransactionTableAfterWithdrawTest() throws InterruptedException {
        TransactionsPage transactionsPage = depositAndWithdrawFromTransaction(100, 20);
        String actualAmount = transactionsPage
                .refreshPage(1)
                .getAmountOfFromLine(2);
        Assert.assertEquals(actualAmount, "20");
    }

    @Test
    public void transactionTypeTransactionTableAfterWithdrawTest() throws InterruptedException {
        TransactionsPage transactionsPage = depositAndWithdrawFromTransaction(100, 20);
        String actualAmount = transactionsPage
                .refreshPage(1)
                .getTransactionTypeFromLine(2);
        Assert.assertEquals(actualAmount, "Debit");
    }

    @Test
    public void resetButtonClearAllItemsInTransactionTableTest() throws InterruptedException {
        TransactionsPage transactionsPage =depositAndWithdrawFromTransaction(100,3);
        int numberOfTransactionsActualResult = transactionsPage.getNumberOfTransactionInTable();
        Assert.assertEquals(numberOfTransactionsActualResult, 2);
        transactionsPage.clickOnResetButton();
        int actualTransactionsNumberAfterReset = transactionsPage.getNumberOfTransactionInTable();
        Assert.assertEquals(actualTransactionsNumberAfterReset, 0);
    }

    @Test
    public void backButtonInTransactionPageTest() {
        String actualPageUrl = getAccountPage()
                .clickOnTransactionButton()
                .pressOnBackButton()
                .getPageUrl();
        String partOfExpectedPageUrl = "account";
        Assert.assertTrue(actualPageUrl.contains(partOfExpectedPageUrl));
    }

    @Test
    public void nextPageButtonInTableTest() throws InterruptedException {
        TransactionsPage transactionsPage = depositManyItemsToTransactionsTable();
        boolean dateDimeColumnLabel = transactionsPage
                .clickOnNextPageButton(2)
                .isDateTimeColumnLabelDisplayed();
        Assert.assertFalse(dateDimeColumnLabel);
    }

    @Test
    public void previousPageButtonInTableButtonTest() throws InterruptedException {
        TransactionsPage transactionsPage = depositManyItemsToTransactionsTable();
        boolean dateDimeColumnLabel = transactionsPage
                .clickOnNextPageButton(2)
                .clickOnBackPageButton(2)
                .isDateTimeColumnLabelDisplayed();
        Assert.assertTrue(dateDimeColumnLabel);
    }


    @Test
    public void topButtonInTableButtonTest() throws InterruptedException {
        TransactionsPage transactionsPage = depositManyItemsToTransactionsTable();
        boolean dateDimeColumnLabel = transactionsPage
                .clickOnNextPageButton(2)
                .clickOnTopButton()
                .isDateTimeColumnLabelDisplayed();
        Assert.assertTrue(dateDimeColumnLabel);
    }

    private TransactionsPage depositManyItemsToTransactionsTable() throws InterruptedException {
        DepositPage depositPage = getAccountPage().clickOnDepositButton();
        depositToAccount(depositPage, ImmutableList.of(100, 2, 3, 4, 5, 6, 7, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 2, 3, 4, 56, 67, 7, 7, 6, 200));
        return depositPage.clickOnTransactionButton();
    }

    private void depositToAccount(DepositPage depositPage, List<Integer> amountList) throws InterruptedException {
        transactionsOperations(depositPage, amountList);
    }

    private void withdrawFromAccount(WithdrawPage withdrawPage, List<Integer> amountList) throws InterruptedException {
        transactionsOperations(withdrawPage, amountList);
    }

    private void transactionsOperations(TransactionsOperations<?> operations, List<Integer> amountList) throws InterruptedException {
        for (int amount : amountList) {
            operations.enterAmountToTextBox(amount);
            operations.clickOnSubmitAmountButton();
        }
    }

    private TransactionsPage depositAndWithdrawFromTransaction(int amountToDeposit, int amountToWithdraw) throws InterruptedException {
        return getAccountPage()
                .clickOnDepositButton()
                .enterAmountToTextBox(amountToDeposit)
                .clickOnSubmitAmountButton()
                .clickOnWithdrawButton()
                .enterAmountToTextBox(amountToWithdraw)
                .clickOnSubmitAmountButton()
                .clickOnTransactionButton()
                .refreshPage(1);
    }

    private AccountPage getAccountPage() {
        return new LoginPage()
                .clickOnCustomerLoginButton()
                .selectNameFromDropDown(CustomerName.HarryPotter)
                .clickOnLoginButton();
    }
}