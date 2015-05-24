package se.thinkcode.selenium.tdd.actions.buy.currency;

import org.junit.Test;
import se.thinkcode.selenium.actions.buy.currency.Action;
import se.thinkcode.selenium.actions.buy.currency.Converter;

import java.util.Currency;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConverterTest {
    @Test
    public void shouldConvertEURtoUSD() {
        int expected = 147;

        Action action = new Action("buy");
        int amount = 170;
        Currency to = Currency.getInstance("USD");
        Currency from = Currency.getInstance("EUR");
        Converter converter = new Converter(action, amount, to, from);

        int actual = converter.getCost();

        assertThat(actual, is(expected));
    }
}
