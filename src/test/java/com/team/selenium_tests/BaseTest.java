package com.team.selenium_tests;

import com.team.framwork.selenium.Initilizer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
public abstract class BaseTest {
    private Initilizer initilizer;
    private  Logger logger;
   // private HomePage homePage;

    @BeforeMethod
    public void setUp() throws Exception {
        logger = LogManager.getLogger(this.getClass());
        this.initilizer = new Initilizer();
  //      homePage= new HomePage();
    }

    @AfterMethod
    public void tearDown() {
       initilizer.closeDriver();;
    }
    public Logger getLogger() {
        return logger;
    }

 //   public HomePage getHomePage() {
//        return homePage;
//    }
}
