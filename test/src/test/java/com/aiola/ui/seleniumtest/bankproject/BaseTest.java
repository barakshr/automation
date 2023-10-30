package com.aiola.ui.seleniumtest.bankproject;

import com.aiola.selenium.BrowserType;
import com.aiola.selenium.ProcessInitiator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    private  ProcessInitiator processInitiator;



    @BeforeMethod
    public void setUp() {
        String aut="https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
        BrowserType browserType= BrowserType.Chrome;
        this.processInitiator = new ProcessInitiator();
        processInitiator.openSeleniumNewBrowser(browserType, aut);
    }

    @AfterMethod
    public void tearDown() {
        processInitiator.closeSeleniumBrowser();
    }
}
