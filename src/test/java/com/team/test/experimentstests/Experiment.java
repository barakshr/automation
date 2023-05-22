package com.team.test.experimentstests;

import com.team.selenium.DriverPool;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Experiment {


    @Test
    public void upload_file() {
        By uploadButton = By.id("file-submit");
        By inputField = By.id("file-upload");

        WebDriverManager.firefoxdriver().setup();
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));


        webDriver.get("https://the-internet.herokuapp.com/upload");
        webDriver.findElement(inputField).sendKeys("/Users/barakshamir/Downloads/playwrightAndroid.png");
        webDriver.findElement(uploadButton).click();
    }

    @Test
    public void rightClick_context_menu_and_accept_js_alert() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));

        webDriver.get("  https://the-internet.herokuapp.com/context_menu");
        WebElement webElement = webDriver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(webDriver);
        //move to element
        actions.moveToElement(webElement);
        //right click
        actions.contextClick().perform();
        //accept alert
        webDriver.switchTo().alert().accept();
    }

    @Test
    public void iframe_html_inside_html() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));

        webDriver.get("https://the-internet.herokuapp.com/nested_frames");
        WebElement frame = webDriver.findElement(By.className("tox-edit-area__iframe"));
        //*
        webDriver.switchTo().frame(frame);
        webDriver.findElement(By.id("tinymce")).clear();
        webDriver.findElement(By.id("tinymce")).sendKeys("hello");
        //*
        webDriver.switchTo().parentFrame();
    }

    @Test
    public void frames_inside_frames_top_middle() {
        WebDriver webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        webDriver.get("https://the-internet.herokuapp.com/nested_frames");

        //*top_middle frame
        WebElement topElementFrame = webDriver.findElement(By.name("frame-top"));
        webDriver.switchTo().frame(topElementFrame);

        //top frame
        WebElement topMiddleElementFrame = webDriver.findElement(By.name("frame-middle"));
        webDriver.switchTo().frame(topMiddleElementFrame);

        //middle frame inside top
        WebElement middle = webDriver.findElement(By.id("content"));
        System.out.println(middle.getText());
        webDriver.switchTo().parentFrame().switchTo().parentFrame();
    }

    @Test
    public void frames_inside_frames_bottom() {
        WebDriver webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        webDriver.get("https://the-internet.herokuapp.com/nested_frames");
        //*bottom frame
        WebElement bottomFrameElement = webDriver.findElement(By.name("frame-bottom"));
        webDriver.switchTo().frame(bottomFrameElement);
        WebElement frameBottomElement = webDriver.findElement(By.tagName("body"));
        String bottom = frameBottomElement.getText();
        System.out.println(bottom);
        webDriver.switchTo().parentFrame();
    }

    @Test
    public void scrollIntoView() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
        webDriver.get("http://the-internet.herokuapp.com/large");
        WebElement webElement = webDriver.findElement(By.id("large-table"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    @Test
    public void setCookie() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver webDriver = new FirefoxDriver();
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        webDriver.manage().addCookie(cookie);
    }
}
