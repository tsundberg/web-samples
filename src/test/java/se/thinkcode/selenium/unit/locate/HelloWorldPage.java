package se.thinkcode.selenium.unit.locate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloWorldPage {
    private final WebDriver browser;

    public HelloWorldPage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl() + "helloWorld.html";
        browser.get(page);

        String expectedTitle = "Hello world";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public String getHeadLine() {
        WebElement headLine = browser.findElement(By.id("headline"));

        return headLine.getText();
    }
}
