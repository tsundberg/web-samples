package se.thinkcode.selenium.actions;

import se.thinkcode.selenium.actions.buy.currency.Action;
import se.thinkcode.selenium.actions.buy.currency.Converter;
import se.thinkcode.selenium.actions.buy.currency.Currency;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConverterTest {
    @Test
    public void shouldConvertEURtoUSD() {
        int expected = 147;

        Action action = new Action("buy");
        int amount = 170;
        Currency to = new Currency("USD");
        Currency from = new Currency("EUR");
        Converter converter = new Converter(action, amount, to, from);

        int actual = converter.getCost();

        assertThat(actual, is(expected));
    }
}
