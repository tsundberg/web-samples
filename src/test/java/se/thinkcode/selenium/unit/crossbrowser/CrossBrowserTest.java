package se.thinkcode.selenium.unit.crossbrowser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import se.thinkcode.selenium.unit.IndexPage;
import se.thinkcode.selenium.unit.locate.HelloWorldPage;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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
        String baseUrl = "http://selenium.thinkcode.se/helloWorld";
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void hello_world() {
        String expected = "Hello, world!";

        HelloWorldPage helloWorldPage = new HelloWorldPage(browser);

        String actual = helloWorldPage.getHeadLine();

        assertThat(actual, is(expected));
    }

    @Parameterized.Parameters
    public static Collection<WebDriver[]> browsers() {
        List<WebDriver[]> browsers = new LinkedList<>();

        browsers.add(new WebDriver[]{new HtmlUnitDriver(true)});
        browsers.add(new WebDriver[]{new FirefoxDriver()});

        return browsers;
    }
}
