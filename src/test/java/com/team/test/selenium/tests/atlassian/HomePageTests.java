package com.team.test.selenium.tests.atlassian;

import com.team.test.selenium.pages.atlassian.HomePage;
import com.team.test.selenium.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class HomePageTests extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setup(){
        homePage= new HomePage();
    }
    @Test
    public void goToWorkManagement() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        homePage
                .goToWorkManagement()
                .checkPageUrlAppear("www.atlassian.com/?tab=work-management");
    }
}
