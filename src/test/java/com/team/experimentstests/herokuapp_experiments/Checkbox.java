package com.team.experimentstests.herokuapp_experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Checkbox extends BaseExperiment {

    @Test
    public void checkbox()  {

        getWebDriver().get("https://the-internet.herokuapp.com/checkboxes");
        WebElement webElement = getWebDriver().findElement(By.id("checkboxes"));
        List<WebElement> webElementList = webElement.findElements(By.tagName("input"));
        WebElement checkBox1 = webElementList.get(0);
        if (!checkBox1.isSelected()) {
            checkBox1.click();
            ;
        }
    }
}
