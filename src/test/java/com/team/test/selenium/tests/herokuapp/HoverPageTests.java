package com.team.test.selenium.tests.herokuapp;

import com.team.test.selenium.pages.herokuapp.HomePage;
import com.team.test.selenium.pages.herokuapp.ViewProfilePage;
import com.team.test.selenium.pages.herokuapp.hover.HoverPage;
import com.team.test.selenium.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class HoverPageTests extends BaseTest {

    @Test
    public void checkImageProfileName() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        String actualProfileName = homePage
                .selectLinkToPage("Hovers")
                .goToPage(HoverPage.class)
                .hoverImage(0)
                .getProfileName();
        String expectedProfileNAme = "name: user1";
        Assert.assertEquals(actualProfileName, expectedProfileNAme, "wrong profile name");
    }

    @Test
    public void checkProfileLink() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        homePage
                .selectLinkToPage("Hovers")
                .goToPage(HoverPage.class)
                .hoverImage(0)
                .clickOnProfile()
                .goToPage(ViewProfilePage.class)
                .checkPageUrlAppear("https://the-internet.herokuapp.com/users/1");
    }


}
