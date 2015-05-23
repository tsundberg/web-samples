package se.thinkcode.selenium.actions;

import se.thinkcode.selenium.actions.convert.Action;
import se.thinkcode.selenium.actions.convert.Conversion;
import se.thinkcode.selenium.actions.convert.Currency;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConversionTest {
    @Test
    public void shouldConvertEURtoUSD() {
        int expected = 147;

        Action action = new Action("buy");
        int amount = 170;
        Currency to = new Currency("USD");
        Currency from = new Currency("EUR");
        Conversion conversion = new Conversion(action, amount, to, from);

        int actual = conversion.getCost();

        assertThat(actual, is(expected));
    }
}
