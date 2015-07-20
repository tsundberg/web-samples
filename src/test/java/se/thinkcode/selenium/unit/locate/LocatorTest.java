package se.thinkcode.selenium.unit.locate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.TestHelper;

import static org.junit.Assert.assertTrue;

public class LocatorTest {
    // Javadoc to the locators: https://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/By.html
    private WebDriver browser;

    @Before
    public void setUp() {
        ApplicationHelper.start();

        browser = TestHelper.getDefaultBrowser();
        String baseUrl = TestHelper.getBaseUrl();
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
        ApplicationHelper.shutdown();
        browser.quit();
    }

    @Test
    public void locate_using_id() {
        String page = browser.getCurrentUrl() + "requestPassword.html";
        browser.get(page);

        WebElement inputField = browser.findElement(By.id("account"));

        requestPassword(inputField);
    }

    @Test
    public void locate_using_name() {
        String page = browser.getCurrentUrl() + "requestPassword.html";
        browser.get(page);

        WebElement inputField = browser.findElement(By.name("account"));

        requestPassword(inputField);
    }

    @Test
    public void locate_using_xpath() {
        String page = browser.getCurrentUrl() + "requestPassword.html";
        browser.get(page);

        WebElement inputField = browser.findElement(By.xpath(".//*[@id='account']"));

        requestPassword(inputField);
    }

    @Test
    public void locate_using_css() {
        String page = browser.getCurrentUrl() + "requestPassword.html";
        browser.get(page);

        WebElement inputField = browser.findElement(By.cssSelector("#account"));

        requestPassword(inputField);
    }

    @Test
    public void locate_using_tagName() {
        String page = browser.getCurrentUrl() + "requestPassword.html";
        browser.get(page);

        WebElement inputField = browser.findElement(By.tagName("input"));

        requestPassword(inputField);
    }

    @Test
    public void locate_using_linktext() {
        browser.findElement(By.linkText("Find an element - hello world"));
    }

    @Test
    public void locate_using_partiallinktext() {
        browser.findElement(By.partialLinkText("Find an element - "));
    }

    private void requestPassword(WebElement inputField) {
        inputField.sendKeys("Gretchen");
        inputField.submit();

        WebElement confirmation = browser.findElement(By.id("confirmation"));
        String confirmationText = confirmation.getText();

        assertTrue("Expected to find Gretchen in the confirmation", confirmationText.contains("Gretchen"));
    }
}
