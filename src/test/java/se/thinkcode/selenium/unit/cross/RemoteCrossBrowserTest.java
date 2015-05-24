package se.thinkcode.selenium.unit.cross;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.junit.SauceOnDemandTestWatcher;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import se.thinkcode.selenium.TestHelper;
import se.thinkcode.selenium.unit.locate.HelloWorldPage;

import java.util.Collection;

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

        String baseUrl = TestHelper.getBaseUrl();
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    @Test
    @Ignore
    public void hello_world() {
        String expected = "Hello world!";
        HelloWorldPage helloWorldPage = new HelloWorldPage(browser);

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
