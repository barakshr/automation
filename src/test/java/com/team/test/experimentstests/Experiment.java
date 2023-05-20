package com.team.test.experimentstests;

import com.team.selenium.DriverPool;
import com.team.test.selenium.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Experiment extends BaseTest {


    @Test
    public void upload_file() {
        By uploadButton = By.id("file-submit");
        By inputField = By.id("file-upload");

        WebDriver webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        webDriver.get("https://the-internet.herokuapp.com/upload");
        webDriver.findElement(inputField).sendKeys("/Users/barakshamir/Downloads/playwrightAndroid.png");
        webDriver.findElement(uploadButton).click();
    }

    @Test
    public void rightClick_context_menu_and_accept_js_alert() {
        WebDriver webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
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
        By frameElement=By.className("tox-edit-area__iframe");


        WebDriver webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        webDriver.get("https://the-internet.herokuapp.com/iframe");
        WebElement frame=webDriver.findElement(frameElement);
        //*
        webDriver.switchTo().frame(frame);
        webDriver.findElement(By.id("tinymce")).clear();
        webDriver.findElement(By.id("tinymce")).sendKeys("hello");
        //*
        webDriver.switchTo().parentFrame();
    }


    @Test
    public void frames_inside_frames() {
    }
}
