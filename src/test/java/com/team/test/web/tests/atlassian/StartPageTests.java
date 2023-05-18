package com.team.test.web.tests.atlassian;


import com.team.selenium.pages.atlassian.StartPage;
import com.team.test.web.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;


public class StartPageTests extends BaseTest {

    @Test
    public void filterResults() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String actualFilterResults = getHomePage().goToLoginPage()
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
