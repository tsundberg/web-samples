package se.thinkcode.selenium.actions.buy.currency;

import org.junit.Test;
import se.thinkcode.selenium.actions.buy.currency.Currency;

import static org.junit.Assert.assertTrue;

public class CurrencyTest {
    @Test
    public void shouldCompareTwoEqualCurrencies() {
        Currency first = new Currency("USD");
        Currency second = new Currency("USD");

        assertTrue(first + " should be equal to " + second, first.equals(second));
    }
}