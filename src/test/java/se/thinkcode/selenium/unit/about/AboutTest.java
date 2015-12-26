package se.thinkcode.selenium.unit.about;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.TestHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AboutTest {
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
    public void about_page() {
        String expected = "A sample site used in the Selenium Course by Think Code AB.";
        AboutPage aboutPage = new AboutPage(browser);

        String actual = aboutPage.getDescription();

        assertThat(actual, is(expected));
    }
}
