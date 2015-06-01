package se.thinkcode.selenium.unit.basic.authentication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.thinkcode.selenium.TestHelper;

import static junit.framework.TestCase.assertTrue;

public class AuthenticationTest {
    private WebDriver browser;

    @Before
    public void setUp() {
        browser = TestHelper.getDefaultBrowser();
    }

    @After
    public void tearDown() {
        browser.close();
    }

    @Test
    public void successful_log_in() {
        String user = "admin";
        String password = "admin";
        String baseUrl = "http://" + user + ":" + password + "@the-internet.herokuapp.com/basic_auth";
        browser.get(baseUrl);

        WebElement message = browser.findElement(By.tagName("p"));

        String actualMessage = message.getText();

        assertTrue("Was not able to login", actualMessage.contains("You must have the proper credentials"));
    }
}
