package se.thinkcode.selenium.unit.datadriven;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.unit.IndexPage;
import se.thinkcode.selenium.unit.form.ConfirmPasswordSentPage;
import se.thinkcode.selenium.unit.form.RequestPasswordPage;

import java.util.Collection;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ChangePasswordTest {
    private WebDriver browser;

    private String account;

    public ChangePasswordTest(String account) {
        this.account = account;
    }

    @Before
    public void setUp() {
        browser = new FirefoxDriver();
        String baseUrl = "http://selenium.thinkcode.se";
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
        browser.close();
    }

    @Test
    public void request_new_password() {
        String expected = "A new password has been sent to " + account;
        IndexPage indexPage = new IndexPage(browser);
        RequestPasswordPage requestPasswordPage = indexPage.requestPassword();

        ConfirmPasswordSentPage confirmPasswordSentPage = requestPasswordPage.requestNewPassword(account);

        String actual = confirmPasswordSentPage.getConfirmationMessage();

        assertThat(actual, is(expected));
    }

    @Parameterized.Parameters
    public static Collection<String[]> accounts() {
        Collection<String[]> accounts = new LinkedList<>();
        accounts.add(new String[]{"Sune"});
        accounts.add(new String[]{"Gretchen"});

        return accounts;
    }
}
