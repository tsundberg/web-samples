package se.thinkcode.selenium.bdd.steps.password;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PasswordSteps {
    private PasswordHelper passwordHelper;

    @Given("^(.*) need a new password$")
    public void a_user_need_a_new_password(String account) throws Throwable {
        passwordHelper = new PasswordHelper(account);
    }

    @When("^the new password is requested$")
    public void the_new_password_is_requested() throws Throwable {
        passwordHelper.sendRequest();
    }

    @Then("^should the confirmation message (.*) be visible$")
    public void should_a_confirmation_message_be_visible(String expected) throws Throwable {
        String actual = passwordHelper.getConfirmationMessage();
        assertThat(actual, is(expected));
    }
}
