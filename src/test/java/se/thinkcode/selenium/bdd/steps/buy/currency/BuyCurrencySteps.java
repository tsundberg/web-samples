package se.thinkcode.selenium.bdd.steps.buy.currency;

import se.thinkcode.selenium.actions.buy.currency.Action;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import se.thinkcode.selenium.ApplicationHelper;

import java.util.Currency;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BuyCurrencySteps {
    private BuyCurrencyHelper conversionHelper;
    private int actualCost;

    @Given("^I want to (.*) (\\d+) (.*) using (.*)$")
    public void i_want_to_convert_money(String actionString, int amount, String targetCurrency, String sourceCurrency) throws Throwable {
        ApplicationHelper.start();

        Action action = new Action(actionString);
        Currency target = Currency.getInstance(targetCurrency);
        Currency source = Currency.getInstance(sourceCurrency);

        conversionHelper = new BuyCurrencyHelper(action, amount, target, source);
        conversionHelper.convert();
    }

    @When("^the conversion is done$")
    public void the_conversion_is_done() throws Throwable {
        actualCost = conversionHelper.getCost();
    }

    @Then("^should it cost me (\\d+) (.*)$")
    public void should_it_cost_me(int expectedCost, String expected) throws Throwable {
        assertThat(actualCost, is(expectedCost));

        Currency expectedCurrency = Currency.getInstance(expected);
        Currency actualCurrency = conversionHelper.getFromCurrency();
        assertThat(actualCurrency, is(expectedCurrency));

        ApplicationHelper.shutdown();
    }
}
