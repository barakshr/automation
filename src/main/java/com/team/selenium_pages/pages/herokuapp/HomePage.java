package com.team.selenium_pages.pages.herokuapp;


import com.team.framwork.selenium.controls.elements.Control;
import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(how = How.TAG_NAME, using = "a")
    List<Control> linksToPages;

    public HomePage selectLinkToPage(String page) {
        Control link = linksToPages.stream().filter(webElement -> webElement.getText().equals(page)).findFirst().get();
        link.click();
        return this;
    }
}
