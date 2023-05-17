package com.team.test.selenium_tests;

import com.team.test.pages.HomePage;
import com.team.test.pages.StartPage;
import com.team.test.selenium_tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;


public class LoginPageTests extends BaseTest {


    @Test
    public void failLoginWrongPassword() {
        String actualText = getHomePage()
                .goToLoginPage()
                .login("nefonoj558@carpetra.com", "123")
                .getLoginFailure();
        String expectedText = "Incorrect email address and / or password. Do you need help logging in?";
        String actualEditedText = actualText.toLowerCase().replaceAll("\\s*", "");
        String expectedEditedText = expectedText.toLowerCase().replaceAll("\\s*", "");
        Assert.assertEquals(actualEditedText, expectedEditedText);
    }


    @Test
    public void loginSuccess() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        getHomePage().goToLoginPage()
                .login("nefonoj558@carpetra.com", "QAZwsx123")
                .goToPage(StartPage.class)
                .checkPageAppear("start.atlassian.com");
    }
}
