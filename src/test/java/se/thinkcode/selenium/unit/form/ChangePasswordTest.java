package se.thinkcode.selenium.unit.form;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.unit.IndexPage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ChangePasswordTest {

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
    public void request_new_password() {
        String expected = "A new password has been sent to Bob";

        IndexPage indexPage = new IndexPage(browser);
        RequestPasswordPage requestPasswordPage =  indexPage.requestPassword();

        ConfirmPasswordSentPage confirmPasswordSentPage = requestPasswordPage.requestNewPassword("Bob");

        String actual = confirmPasswordSentPage.getConfirmationMessage();

        assertThat(actual, is(expected));
    }

}
