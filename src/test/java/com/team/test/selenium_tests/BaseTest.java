package com.team.test.selenium_tests;

import com.team.selenium.Initilizer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private Initilizer initilizer;

    @BeforeMethod
    public void setUp() throws Exception {
        this.initilizer = new Initilizer();

    }

    @AfterMethod
    public void tearDown() {
       initilizer.closeDriver();;
    }
}
