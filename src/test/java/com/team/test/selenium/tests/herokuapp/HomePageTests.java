package com.team.test.selenium.tests.herokuapp;

import com.team.test.selenium.pages.herokuapp.HomePage;
import com.team.test.selenium.tests.BaseTest;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void goToDropDown(){
        HomePage homePage= new HomePage();
        homePage
                .selectLinkToPage("Dropdown")
                .checkPageUrlAppear("https://the-internet.herokuapp.com/dropdown");
    }
}
