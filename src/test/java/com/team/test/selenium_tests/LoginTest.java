package com.team.test.selenium_tests;

import com.team.test.pages.HomePage;
import com.team.test.pages.LoginPage;
import org.testng.annotations.Test;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class LoginTest extends BaseTest {


    @Test
    public void homePage() throws  InterruptedException {
        HomePage homePage = new HomePage();
        homePage.clickOnWorkManagement();
    }


    @Test
    public void homePage2() throws  InterruptedException {
        HomePage homePage = new HomePage();
        homePage.clickOnIt();
    }


    @Test
    public void loginP() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, IOException, InterruptedException {

        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage
                .login("", "")
                .goToPage(HomePage.class)
                .clickOnWorkManagement();

    }
}
