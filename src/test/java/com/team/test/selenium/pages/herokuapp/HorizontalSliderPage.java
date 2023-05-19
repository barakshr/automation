package com.team.test.selenium.pages.herokuapp;

import com.team.test.selenium.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HorizontalSliderPage extends BasePage {

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div/input")
    WebElement sliderButton;

    @FindBy(how = How.ID, using = "range")
    WebElement sliderRange;


    public HorizontalSliderPage moveHorizontalSliderWithArrows(int toRange) {
        sliderButton.click();
        float currentRange = Float.parseFloat(sliderRange.getText());
        float steps = (toRange - currentRange) * 2;
        Keys arrowMovement ;
        if (steps < 0) {
            arrowMovement = Keys.ARROW_LEFT;
            steps *= -1;
        } else {
            arrowMovement = Keys.ARROW_RIGHT;
        }

        for (int i = 0; i < steps; i++) {
            sliderButton.sendKeys(arrowMovement);
        }
        return this;
    }

    public String getSliderRange() {
        return sliderRange.getText();
    }
}
