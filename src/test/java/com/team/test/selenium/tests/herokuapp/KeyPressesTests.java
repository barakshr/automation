package com.team.test.selenium.tests.herokuapp;

import com.team.test.selenium.pages.herokuapp.HomePage;
import com.team.test.selenium.pages.herokuapp.KeyPressesPage;
import com.team.test.selenium.tests.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class KeyPressesTests extends BaseTest {

    @Test
    public void enterDollarSignToTextBox() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        String actualTest = homePage
                .selectLinkToPage("Key Presses")
                .goToPage(KeyPressesPage.class)
                .enterText(Keys.chord(Keys.SHIFT, "4"))
                .getTextInTextBox();
    }


}
