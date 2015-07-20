package se.thinkcode.selenium.unit.popup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.TestHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AlertTest {
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
    public void handle_alert() {
        String expected = "You clicked an alert";
        AlertPage alertPage = new AlertPage(browser);

        alertPage.clickAlert();

        String actual = alertPage.getResult();

        assertThat(actual, is(expected));
    }

    @Test
    public void confirm_confirmation() {
        String expected = "You clicked: Ok";
        AlertPage alertPage = new AlertPage(browser);

        alertPage.confirm();

        String actual = alertPage.getResult();

        assertThat(actual, is(expected));
    }

    @Test
    public void dismiss_confirmation() {
        String expected = "You clicked: Cancel";
        AlertPage alertPage = new AlertPage(browser);

        alertPage.dismiss();

        String actual = alertPage.getResult();

        assertThat(actual, is(expected));
    }

    @Test
    public void add_text_to_prompt() {
        String expected = "You entered: My response";
        AlertPage alertPage = new AlertPage(browser);

        alertPage.add_text_to_prompt("My response");

        String actual = alertPage.getResult();

        assertThat(actual, is(expected));
    }


}
