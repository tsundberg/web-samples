package se.thinkcode.selenium.unit.form;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.TestHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ChangePasswordTest {

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
        browser.close();
    }

    @Test
    public void change_password() {
        String expected = "A new password has been sent to Bob";
        RequestNewPasswordPage requestNewPasswordPage = new RequestNewPasswordPage(browser);

        ConfirmPasswordSentPage confirmPasswordSentPage = requestNewPasswordPage.requestNewPassword("Bob");

        String actual = confirmPasswordSentPage.getConfirmationMessage();

        assertThat(actual, is(expected));
    }

}
