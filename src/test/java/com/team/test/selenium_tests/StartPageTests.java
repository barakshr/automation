package com.team.test.selenium_tests;


import com.team.test.pages.HomePage;
import com.team.test.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;


public class StartPageTests extends BaseTest {

    @Test
    public void filterResults() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        String actualFilterResults = homePage.goToLoginPage()
                .login("nefonoj558@carpetra.com", "QAZwsx123").
                goToPage(StartPage.class)
                .filterByTitle("abc")
                .getFilterResults();
        String expectedFilterResults = "We couldn't find any recent work matching your search";
        Assert.assertEquals(actualFilterResults, expectedFilterResults);
    }

}
