package se.thinkcode.selenium.bdd.steps.password;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.unit.IndexPage;

public class PasswordHelper {
    private String account;

    private WebDriver browser;
    private ConfirmationPage confirmationPage;

    public PasswordHelper(String account) {
        this.account = account;
        browser = new FirefoxDriver();
        String baseUrl = "http://selenium.thinkcode.se";
        browser.get(baseUrl);
    }

    public void sendRequest() {
        IndexPage indexPage = new IndexPage(browser);
        indexPage.requestPassword();

        RequestPage requestPage = new RequestPage(browser);

        requestPage.enterAccountName(account);
        confirmationPage = requestPage.submitRequest();
    }

    public String getConfirmationMessage() {
        return confirmationPage.getConfirmationMessage();
    }
}
