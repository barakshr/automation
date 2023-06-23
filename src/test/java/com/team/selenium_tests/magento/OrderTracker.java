package com.team.selenium_tests.magento;

import com.team.framwork.selenium.DriverPool;
import com.team.framwork.selenium.properties.Settings;
import com.team.selenium_pages.pages.magento.HomePage;
import com.team.selenium_pages.pages.magento.PaymentPage;
import com.team.selenium_tests.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

public class OrderTracker extends BaseTest  {

    @Test
    public void writeOrderIdToFile() throws Exception {
        HomePage homePage = new HomePage();
        String orderId = homePage.hoverOnGear()
                .enterBagsOption()
                //bag
                .addBagToCart(0)
                .goToCheckoutPage()
                .waitForPageToLoad(Duration.ofSeconds(5))
                .enterEmailAddress("bobi@gmail.com")
                .enterFirstName("bobi")
                .enterLastName("sami")
                .enterCompanyName("intentIQ")
                .selectCountry("IL")
                .enterCity("tel aviv")
                .enterStreetFirstTextBox("hertsel")
                .enterZipCode("6810104")
                .enterPhoneNumber("0529653215")
                .setRateShipment()
                .clickOnNext()
                .goToPage(PaymentPage.class)
                .clickOnPlaceOrder()
                .getOrderId();
        writeToTxtFile("orderId:"+orderId);
    }



    private void writeToTxtFile(String orderId) throws IOException {
        FileWriter fileWriter = new FileWriter(Settings.DataFilePath);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(orderId);
        printWriter.close();
    }

    @Test
    public void sss() throws IOException {
      writeToTxtFile("1234");
    }


    @Test
    public void addThirdPartyCookie() {
        WebDriver webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        Cookie cookie = new Cookie.Builder("name", "value")
                .domain("bobo.com")
                .expiresOn(new Date(2015, 10, 28))
                .isHttpOnly(true)
                .isSecure(false)
                .path("/mypath").build();
        webDriver.manage().addCookie(cookie);
        Set<Cookie> cookieList = webDriver.manage().getCookies();
    }

    @Test
    public void addDomainCookie() {
        WebDriver webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        Cookie cookie = new Cookie.Builder("name", "value")
                .domain("magento.softwaretestingboard.com")
                .expiresOn(new Date(2015, 10, 28))
                .isHttpOnly(true)
                .isSecure(false)
                .path("/mypath").build();

        webDriver.manage().addCookie(cookie);
        Set<Cookie> cookieList = webDriver.manage().getCookies();
    }

}
