package se.thinkcode.selenium.steps.password;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.TestHelper;

import java.io.IOException;

public class PasswordHelper {
    private String account;

    private WebDriver browser;
    private ConfirmationPage confirmationPage;

    public PasswordHelper(String account) throws IOException {
        this.account = account;
        browser = new FirefoxDriver();
        String baseUrl = TestHelper.getBaseUrl();
        browser.get(baseUrl);
    }

    public void sendRequest() {
        RequestPage requestPage = new RequestPage(browser);

        requestPage.enterAccountName(account);
        confirmationPage = requestPage.submitRequest();
    }

    public String getConfirmationMessage() {
        return confirmationPage.getConfirmationMessage();
    }
}
