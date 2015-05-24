package se.thinkcode.selenium.tdd.actions.buy.currency;

import org.junit.Test;
import se.thinkcode.selenium.actions.buy.currency.Action;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ActionTest {
    @Test
    public void shouldGetBuyActionAsString() {
        String expected = "buy";
        Action action = new Action("BuY");

        String actual = action.getAction();

        assertThat(actual, is(expected));
    }
}