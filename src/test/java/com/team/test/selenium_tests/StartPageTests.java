package com.team.test.selenium_tests;


import com.team.test.pages.HomePage;
import com.team.test.pages.StartPage;
import com.team.test.selenium_tests.base.BaseTest;
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

        String expectedFilterResults = "We couldn't find any recent work matching your search Try again with a different term.";
        String actualEditedText = actualFilterResults.toLowerCase().replaceAll("\\s*", "");
        String expectedEditedText = expectedFilterResults.toLowerCase().replaceAll("\\s*", "");
        Assert.assertEquals(actualEditedText, expectedEditedText);
    }

}
