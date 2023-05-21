package com.team.test.selenium.tests.herokuapp;

import com.team.test.selenium.pages.herokuapp.DynamicWait.DynamicLoadingPage;
import com.team.test.selenium.pages.herokuapp.HomePage;
import com.team.test.selenium.tests.BaseTest;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class DynamicElementsWaitPageTests extends BaseTest {


    @Test
    public void fff() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        homePage
                .selectLinkToPage("Dynamic Loading")
                .goToPage(DynamicLoadingPage.class)
                .goToElementRenderedAfterTheFact()
                .press();
    }

}
