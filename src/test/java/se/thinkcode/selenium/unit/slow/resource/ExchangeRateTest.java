package se.thinkcode.selenium.unit.slow.resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.unit.IndexPage;

import java.util.Currency;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExchangeRateTest {
    private WebDriver browser;

    @Before
    public void setUp() {
        browser = new FirefoxDriver();
        String baseUrl = "http://selenium.thinkcode.se/exchangeRate";
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
        browser.close();
    }

    @Test
    public void wait_for_slow_exchange_rate_server() {
        float expected = 2.07f;

        RequestExchangeRatePage requestExchangeRatePage = new RequestExchangeRatePage(browser);

        Currency from = Currency.getInstance("RON");
        Currency to = Currency.getInstance("SEK");
        ExchangeRatePage exchangeRatePage = requestExchangeRatePage.getExchangeRate(from, to);

        float actual = exchangeRatePage.getExchangeRate();

        assertThat(actual, is(expected));
    }
}
