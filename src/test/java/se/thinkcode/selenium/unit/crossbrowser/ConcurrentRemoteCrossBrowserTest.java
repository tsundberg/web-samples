package se.thinkcode.selenium.unit.crossbrowser;

import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import org.openqa.selenium.WebDriver;

// @RunWith(ConcurrentParameterized.class)
public class ConcurrentRemoteCrossBrowserTest implements SauceOnDemandSessionIdProvider {

    private WebDriver browser;
    private String sessionId;

/*
    @Rule
    public SauceOnDemandTestWatcher resultReportingTestWatcher;

    public ConcurrentRemoteCrossBrowserTest(WebDriver browser) {
        this.browser = browser;

        SauceOnDemandAuthentication authentication = TestHelper.getSauceLabsAuthentication();
        resultReportingTestWatcher = new SauceOnDemandTestWatcher(this, authentication);
        sessionId = (((RemoteWebDriver) browser).getSessionId()).toString();

        String baseUrl = TestHelper.getBaseUrl();
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void hello_world() throws Exception {
        String expected = "Hello, world!";
        IndexPage indexPage = new IndexPage(browser);
        HelloWorldPage helloWorldPage = indexPage.helloWorld();

        String actual = helloWorldPage.getHeadLine();

        assertThat(actual, is(expected));
    }

    @ConcurrentParameterized.Parameters
    public static Collection<WebDriver[]> browsers() {
        return TestHelper.getRemoteCrossBrowsers("Parallel Hello world");
    }
    */

    @Override
    public String getSessionId() {
        return sessionId;
    }
}
