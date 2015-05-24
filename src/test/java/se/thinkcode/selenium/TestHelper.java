package se.thinkcode.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestHelper {
    public static String getBaseUrl() {
        return "http://selenium.thinkcode.se";
        // return "http://localhost:8080";
    }

    public static WebDriver getDefaultBrowser(){
        return new HtmlUnitDriver(true);
        // return new FirefoxDriver();
    }
}
