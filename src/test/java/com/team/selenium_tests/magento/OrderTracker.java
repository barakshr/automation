package com.team.selenium_tests.magento;

import com.team.framwork.selenium.DriverPool;
import com.team.selenium_pages.pages.magento.HomePage;
import com.team.selenium_tests.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Set;

public class OrderTracker extends BaseTest {

    @Test
    public void idTracking() throws Exception {
        HomePage homePage = new HomePage();
        String orderId = homePage.hoverOnGear()
                .enterBagsOption()
                .addBagToCart(0)
                .goToCheckout()
                .enterEmailAddress("bobi@gmail.com")
                .enterFirstName("bobi")
                .enterLastName("sami")
                .enterCompanyName("intentIQ")
                .enterCity("tel aviv")
                .enterPhoneNumber("0529653215")
                .enterZipCode("6687865")
                .enterStreetFirstTextBox("herzel")
                .selectCountry("Israel")
                .clickOnNext()
                .clickOnPlaceOrder()
                .getOrderId();

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
