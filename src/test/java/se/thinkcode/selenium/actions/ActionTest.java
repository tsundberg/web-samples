package se.thinkcode.selenium.actions;

import org.junit.Test;
import se.thinkcode.selenium.actions.convert.Action;

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