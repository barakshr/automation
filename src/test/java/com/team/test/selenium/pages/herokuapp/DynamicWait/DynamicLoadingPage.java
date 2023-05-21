package com.team.test.selenium.pages.herokuapp.DynamicWait;

import com.team.selenium.controls.elements.Button;
import com.team.test.selenium.pages.BasePage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DynamicLoadingPage extends BasePage {

    //    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/a[2]")
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Element rendered after')]")
    Button elementRenderedAfterTheFact;


    public ElementRenderedAfterTheFactPage goToElementRenderedAfterTheFact() {
        elementRenderedAfterTheFact.click();
        return new ElementRenderedAfterTheFactPage();
    }


}
