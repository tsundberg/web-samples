package se.thinkcode.selenium.unit.popup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.unit.IndexPage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AlertTest {
    private WebDriver browser;
    private AlertPage alertPage;

    @Before
    public void setUp() {
        browser = new FirefoxDriver();
        String baseUrl = "http://selenium.thinkcode.se";
        browser.get(baseUrl);
        IndexPage indexPage = new IndexPage(browser);
        alertPage = indexPage.alert();
    }

    @After
    public void tearDown() {
        browser.close();
    }

    @Test
    public void handle_alert() {
        String expected = "You clicked an alert";

        alertPage.clickAlert();
        String actual = alertPage.getResult();

        assertThat(actual, is(expected));
    }

    @Test
    public void confirm_confirmation() {
        String expected = "You clicked: Ok";

        alertPage.confirm();
        String actual = alertPage.getResult();

        assertThat(actual, is(expected));
    }

    @Test
    public void dismiss_confirmation() {
        String expected = "You clicked: Cancel";

        alertPage.dismiss();
        String actual = alertPage.getResult();

        assertThat(actual, is(expected));
    }

    @Test
    public void add_text_to_prompt() {
        String expected = "You entered: My response";

        alertPage.add_text_to_prompt("My response");
        String actual = alertPage.getResult();

        assertThat(actual, is(expected));
    }
}
