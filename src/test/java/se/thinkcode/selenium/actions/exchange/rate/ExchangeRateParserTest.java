package se.thinkcode.selenium.actions.exchange.rate;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExchangeRateParserTest {

    @Test
    public void parse_exchange_rate() {
        String sample = "The exchangeRate from SEK to RON is 2.07";
        float expected = 2.07f;

        ExchangeRatePage exchangeRatePage = new ExchangeRatePage();

        float actual = exchangeRatePage.parseResult(sample);

        assertThat(actual, is(expected));
    }
}
