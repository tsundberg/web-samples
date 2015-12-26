package se.thinkcode.selenium.unit.about;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AboutPage {
    private final WebDriver browser;

    public AboutPage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl() + "about";
        browser.get(page);

        String expectedTitle = "About";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public String getDescription() {
        return browser.findElement(By.id("description")).getText();
    }
}
