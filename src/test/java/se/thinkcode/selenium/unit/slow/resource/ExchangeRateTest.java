package se.thinkcode.selenium.unit.slow.resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.TestHelper;
import se.thinkcode.selenium.unit.IndexPage;

import java.util.Currency;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExchangeRateTest {
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
    public void wait_for_slow_exchange_rate_server() {
        float expected = 2.07f;

        IndexPage indexPage = new IndexPage(browser);
        RequestExchangeRatePage requestExchangeRatePage = indexPage.requestExchangeRate();

        Currency from = Currency.getInstance("RON");
        Currency to = Currency.getInstance("SEK");
        ExchangeRatePage exchangeRatePage = requestExchangeRatePage.getExchangeRate(from, to);

        float actual = exchangeRatePage.getExchangeRate();

        assertThat(actual, is(expected));
    }
}
