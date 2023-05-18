package com.team.test.selenium_tests.atlassian;

import com.team.test.selenium_tests.BaseTest;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class HomePageTests extends BaseTest {

    @Test
    public void goToWorkManagement() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        getHomePage()
                .goToWorkManagement()
                .checkPageAppear("www.atlassian.com/?tab=work-management");
    }
}
