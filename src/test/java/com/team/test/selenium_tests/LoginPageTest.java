package com.team.test.selenium_tests;

import com.team.test.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {


    @Test
    public void failLoginWrongPassword() {
        HomePage homePage = new HomePage();
        String actualText = homePage
                .goToLoginPage()
                .login("nefonoj558@carpetra.com", "123")
                .getLoginFailure();
        String expectedText = "Incorrect email address and / or password. Do you need help logging in";
        String actualEditedText = expectedText.toLowerCase().replaceAll("\\s*", "");
        String expectedEditedText = expectedText.toLowerCase().replaceAll("\\s*", "");
        Assert.assertEquals(actualEditedText, expectedEditedText);
    }


    @Test
    public void loginSuccess() {
        HomePage homePage = new HomePage();
        homePage
                .goToLoginPage()
                .login("nefonoj558@carpetra.com", "QAZwsx123")
                .checkStartPageAppear();
    }

    @Test
    public void goToWorkManagement() {
        HomePage homePage = new HomePage();
        homePage.clickOnWorkManagement();
        Assert.fail();
    }
}
