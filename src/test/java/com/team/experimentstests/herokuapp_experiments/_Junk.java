package com.team.experimentstests.herokuapp_experiments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


public class _Junk extends BaseExperiment {

    @Test
    public void test() throws IOException, InterruptedException {
        getWebDriver().get("https://the-internet.herokuapp.com/shadowdom");
      WebElement webElement= getWebDriver().findElement(By.xpath("/html/body/div[2]/div/my-paragraph[1]/span"));

    }
}
