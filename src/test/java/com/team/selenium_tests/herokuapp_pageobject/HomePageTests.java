package com.team.selenium_tests.herokuapp_pageobject;

import com.team.selenium_pages.pages.herokuapp.HomePage;
import com.team.selenium_tests.BaseTest;
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
