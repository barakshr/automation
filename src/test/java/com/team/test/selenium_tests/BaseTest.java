package com.team.test.selenium_tests;

import com.team.selenium.Initilizer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
public abstract class BaseTest {
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
