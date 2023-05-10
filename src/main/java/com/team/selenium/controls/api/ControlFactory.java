package com.team.selenium.controls.api;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Karthik-pc on 12/10/2016.
 */

public class ControlFactory extends PageFactory {

    public static void initElements(WebDriver driver, Object page) {
            PageFactory.initElements(new ControlFieldDecorator(new DefaultElementLocatorFactory(driver)), page);
    }
}
