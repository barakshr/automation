package com.team.test.selenium_tests;

import com.team.test.pages.HomePage;
import com.team.test.pages.WorkManagementPage;
import com.team.test.selenium_tests.base.BaseTest;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class HomePageTests extends BaseTest {

    @Test
    public void goToWorkManagement() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        homePage.
                clickOnWorkManagement()
                .goToPage(WorkManagementPage.class)
                .checkPageAppear("www.atlassian.com/?tab=work-management");
    }
}
