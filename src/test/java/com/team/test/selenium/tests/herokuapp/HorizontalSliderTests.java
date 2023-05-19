package com.team.test.selenium.tests.herokuapp;

import com.team.test.selenium.pages.herokuapp.HomePage;
import com.team.test.selenium.pages.herokuapp.HorizontalSliderPage;
import com.team.test.selenium.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class HorizontalSliderTests extends BaseTest {

    @Parameters ({"rangeVal"})
    @Test
    public void moveHorizontalSliderWithArrows(Integer rangeVal) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        String actualRange = homePage
                .selectLinkToPage("Horizontal Slider")
                .goToPage(HorizontalSliderPage.class)
                .moveHorizontalSliderWithArrows(rangeVal)
                .getSliderRange();
        String expectedRang = rangeVal.toString();
        Assert.assertEquals(actualRange, expectedRang);
    }
}
