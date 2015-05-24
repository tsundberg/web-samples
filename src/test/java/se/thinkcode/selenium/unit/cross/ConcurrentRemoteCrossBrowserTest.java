package se.thinkcode.selenium.unit.cross;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.junit.ConcurrentParameterized;
import com.saucelabs.junit.SauceOnDemandTestWatcher;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import se.thinkcode.selenium.TestHelper;
import se.thinkcode.selenium.unit.locate.HelloWorldPage;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
        String expected = "Hello world!";
        HelloWorldPage helloWorldPage = new HelloWorldPage(browser);

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
