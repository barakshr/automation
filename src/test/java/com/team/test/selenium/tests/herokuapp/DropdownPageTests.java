package com.team.test.selenium.tests.herokuapp;

import com.team.test.selenium.pages.herokuapp.DropdownPage;
import com.team.test.selenium.pages.herokuapp.HomePage;
import com.team.test.selenium.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class DropdownPageTests extends BaseTest {

    @Test
    //
    public void dropdown() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        List<String> selection = homePage
                .selectLinkToPage("Dropdown")
                .goToPage(DropdownPage.class)
                .selectFormDropdown("1")
                .getSelections();
        Assert.assertEquals(selection.size(), 1, "more or less then one selection");
        Assert.assertEquals(selection.get(0), "Option 1"," option was not selected");

    }

}
