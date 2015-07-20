package se.thinkcode.selenium.unit.popup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.TestHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NewPageTest {
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
    public void should_switch_to_new_page() {
        String expected = "Greetings from pop-up!";

        NewPage newPage = new NewPage(browser);

        String actual = newPage.getHeadline();

        assertThat(actual, is(expected));
    }
}
