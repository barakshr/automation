package com.team.test.selenium.pages.herokuapp.hover;


import com.team.test.selenium.pages.BasePage;
import com.team.test.selenium.pages.herokuapp.hover.FigureCaptionElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HoverPage extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = "figure")
    List<WebElement> images;

    @FindBy(how = How.CLASS_NAME, using = "figcaption")
    List<WebElement> figureCaption;


    public FigureCaptionElement hoverImage(int imageIndex) {
        WebElement hoveredImage = images.get(imageIndex);
        getActions().moveToElement(hoveredImage).perform();
        return new FigureCaptionElement(hoveredImage);
    }

}
