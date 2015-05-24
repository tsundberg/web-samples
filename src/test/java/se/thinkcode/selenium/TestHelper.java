package se.thinkcode.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestHelper {
    public static String getBaseUrl() {
        return "http://selenium.thinkcode.se";
        // return "http://localhost:8080";
    }

    public static WebDriver getDefaultBrowser(){
        return new FirefoxDriver();
    }
}
