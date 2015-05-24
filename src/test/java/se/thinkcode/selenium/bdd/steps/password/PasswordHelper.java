package se.thinkcode.selenium.bdd.steps.password;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.TestHelper;

public class PasswordHelper {
    private String account;

    private WebDriver browser;
    private ConfirmationPage confirmationPage;

    public PasswordHelper(String account) {
        this.account = account;
        browser = TestHelper.getDefaultBrowser();
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
