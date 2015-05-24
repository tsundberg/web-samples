package se.thinkcode.selenium.actions.exchange.rate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.TestHelper;

import java.util.Currency;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExchangeRateTest {
    private WebDriver browser;

    @Before
    public void setUp() {
        ApplicationHelper.start();

        browser = new FirefoxDriver();
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

        RequestExchangeRatePage requestExchangeRatePage = new RequestExchangeRatePage(browser);
        Currency from = Currency.getInstance("SEK");
        Currency to = Currency.getInstance("RON");
        ExchangeRatePage exchangeRatePage = requestExchangeRatePage.getExchangeRate(from, to);

        float actual = exchangeRatePage.getExchangeRate();

        assertThat(actual, is(expected));
    }
}
