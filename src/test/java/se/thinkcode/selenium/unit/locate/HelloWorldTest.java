package se.thinkcode.selenium.unit.locate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.unit.IndexPage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloWorldTest {
    private WebDriver browser;

    @Before
    public void setUp() {
        browser = new FirefoxDriver();
        String baseUrl = "http://selenium.thinkcode.se";
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
        browser.close();
    }

    @Test
    public void hello_world_no_page_object() {
        String expected = "Hello, world!";

        String page = browser.getCurrentUrl() + "helloWorld";
        browser.get(page);

        WebElement headLine = browser.findElement(By.id("headline"));

        String actual = headLine.getText();

        assertThat(actual, is(expected));
    }

    @Test
    public void hello_world_page_object() {
        String expected = "Hello, world!";
        IndexPage indexPage = new IndexPage(browser);
        HelloWorldPage helloWorldPage = indexPage.helloWorld();

        String actual = helloWorldPage.getHeadLine();

        assertThat(actual, is(expected));
    }

}
