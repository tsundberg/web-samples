package se.thinkcode.selenium.unit.cross;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.TestHelper;
import se.thinkcode.selenium.unit.locate.HelloWorldPage;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CrossBrowserTest {
    private WebDriver browser;

    public CrossBrowserTest(WebDriver browser) {
        this.browser = browser;
    }

    @Before
    public void setUp() {
        ApplicationHelper.start();

        String baseUrl = TestHelper.getBaseUrl();
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
        ApplicationHelper.shutdown();
        browser.quit();
    }

    @Test
    public void hello_world() {
        String expected = "Hello world!";
        HelloWorldPage helloWorldPage = new HelloWorldPage(browser);

        String actual = helloWorldPage.getHeadLine();

        assertThat(actual, is(expected));
    }

    @Parameterized.Parameters
    public static Collection<WebDriver[]> browsers() {
        return TestHelper.getCrossBrowsers();
    }
}
