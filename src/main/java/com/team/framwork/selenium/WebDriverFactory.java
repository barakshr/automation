package com.team.framwork.selenium;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.framwork.selenium.properties.BrowsePropertiesPojo;
import com.team.framwork.selenium.properties.BrowserOptionsPojo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class WebDriverFactory {

    private final static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public static void openNewWebDriver(BrowserType browserType) throws Exception {
        String path = System.getProperty("user.dir") + "/src/main/resources";
        Path browserOptions = Paths.get(path + "/global-browser-options.json");
        String globalOptionsString = Files.readString(browserOptions);
        ObjectMapper objectMapper = new ObjectMapper();
        BrowserOptionsPojo browsePropertiesPojo = objectMapper.readValue(globalOptionsString, BrowserOptionsPojo.class);
        WebDriver webDriver = null;
        //TODO: hard coded settings, should be in config file
        switch (browserType) {
            case Firefox:
                FirefoxProfile profile = new ProfilesIni().getProfile("default");
                profile.setPreference("network.cookie.cookieBehavior", 1);
                FirefoxOptions options = new FirefoxOptions();
                options.setProfile(profile);
                browsePropertiesPojo.getBrowsePropertiesPojoList().forEach(x->options.addPreference(x.getKey(),x.getValue()));
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver(options);

                break;
            case Chrome:
                ChromeOptions chromeOptions = new ChromeOptions();
                Path chromeExperimentalOptionsPath = Paths.get(path + "/chrome-broswer-experimental-options.json");
                String chromeExperimentalOptionsString = Files.readString(chromeExperimentalOptionsPath);
                BrowserOptionsPojo chromeExperimentalOptions = objectMapper.readValue(chromeExperimentalOptionsString, BrowserOptionsPojo.class);
                Map<String, Object> prefs = new HashMap();
                chromeExperimentalOptions.getBrowsePropertiesPojoList().forEach(x->prefs.put(x.getKey(),x.getValue()));
                browsePropertiesPojo.getBrowsePropertiesPojoList().forEach(x->chromeOptions.setCapability(x.getKey(),x.getValue()));
                chromeOptions.setExperimentalOption("prefs", prefs);
                System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver");
                ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
                webDriver = chromeDriver;
                break;

            case IE:
                throw new Exception("IE not web driver not implemented");
        }
        DriverPool.getInstance().setDriver(Thread.currentThread().getId(), webDriver);
    }

}
