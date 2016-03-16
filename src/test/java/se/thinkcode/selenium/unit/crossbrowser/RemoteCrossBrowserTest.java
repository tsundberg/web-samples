package se.thinkcode.selenium.unit.crossbrowser;

import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

// @RunWith(Parameterized.class)
public class RemoteCrossBrowserTest implements SauceOnDemandSessionIdProvider {
    private WebDriver browser;
    private String sessionId;

    /*
    @Rule
    public SauceOnDemandTestWatcher resultReportingTestWatcher;

    public RemoteCrossBrowserTest(WebDriver browser) {
        this.browser = browser;

        SauceOnDemandAuthentication authentication = TestHelper.getSauceLabsAuthentication();
        resultReportingTestWatcher = new SauceOnDemandTestWatcher(this, authentication);
        sessionId = (((RemoteWebDriver) browser).getSessionId()).toString();

        String baseUrl = "http://selenium.thinkcode.se";
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    @Test
    @Ignore
    public void hello_world() {
        String expected = "Hello, world!";
        IndexPage indexPage = new IndexPage(browser);
        HelloWorldPage helloWorldPage = indexPage.helloWorld();

        String actual = helloWorldPage.getHeadLine();

        assertThat(actual, is(expected));

    }

    @Parameterized.Parameters
    public static Collection<WebDriver[]> browsers() {
        return TestHelper.getRemoteCrossBrowsers("Serial Hello world");
    }
    */

    @Override
    public String getSessionId() {
        return sessionId;
    }
}
