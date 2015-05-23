package se.thinkcode.selenium.steps.convert;

import se.thinkcode.selenium.actions.convert.Action;
import se.thinkcode.selenium.actions.convert.Currency;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import se.thinkcode.selenium.steps.ApplicationHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConversionSteps {
    private ConversionHelper conversionHelper;
    private int actualCost;

    @Given("^I want to (.*) (\\d+) (.*) using (.*)$")
    public void i_want_to_convert_money(String actionString, int amount, String targetCurrency, String sourceCurrency) throws Throwable {
        ApplicationHelper.start();

        Action action = new Action(actionString);
        Currency target = new Currency(targetCurrency);
        Currency source = new Currency(sourceCurrency);

        conversionHelper = new ConversionHelper(action, amount, target, source);
        conversionHelper.convert();
    }

    @When("^the conversion is done$")
    public void the_conversion_is_done() throws Throwable {
        actualCost = conversionHelper.getCost();
    }

    @Then("^should it cost me (\\d+) (.*)$")
    public void should_it_cost_me(int expectedCost, String expected) throws Throwable {
        assertThat(actualCost, is(expectedCost));

        Currency expectedCurrency = new Currency(expected);
        Currency actualCurrency = conversionHelper.getFromCurrency();
        assertThat(actualCurrency, is(expectedCurrency));

        ApplicationHelper.shutdown();
    }
}
