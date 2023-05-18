package com.team.test.selenium.pages.herokuapp;

import com.team.test.selenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;


public class DropdownPage extends BasePage {

    @FindBy(how = How.ID, using = "dropdown")
    private WebElement dropdown;


    public DropdownPage selectFormDropdown(String option) {
        Select dropdownSelect = new Select(dropdown);
        dropdownSelect.selectByValue(option);
        return this;
    }

    public List<String> getSelections() {
        Select dropdownSelect = new Select(dropdown);
        return dropdownSelect.getAllSelectedOptions().stream().map(webElement -> webElement.getText()).collect(Collectors.toList());
    }
}
