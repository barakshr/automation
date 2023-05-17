package com.team.test.selenium_tests.base;

import com.team.selenium.Initilizer;
import com.team.test.selenium_tests.base.Listener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
public abstract class BaseTest {
    private Initilizer initilizer;
    private  Logger logger;

    @BeforeMethod
    public void setUp() throws Exception {
        logger = LogManager.getLogger(this.getClass());
        this.initilizer = new Initilizer();
    }

    @AfterMethod
    public void tearDown() {
       initilizer.closeDriver();;
    }
    public Logger getLogger() {
        return logger;
    }
}
