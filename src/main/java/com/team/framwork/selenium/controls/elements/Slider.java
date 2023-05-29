package com.team.framwork.selenium.controls.elements;

import com.team.framwork.selenium.controls.api.ImplementedBy;
import org.openqa.selenium.Keys;

@ImplementedBy(SliderImp.class)
public interface Slider extends Control {

     void moveSliderWithArrow(Keys arrowKey, float numberOfPress);
}
