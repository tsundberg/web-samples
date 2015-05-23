package se.thinkcode.selenium.steps.password;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.Main;
import se.thinkcode.selenium.steps.ApplicationHelper;

public class PasswordHelper {
    private String account;

    private WebDriver browser = new FirefoxDriver();
    private ConfirmationPage confirmationPage;

    public PasswordHelper(String account) {
        this.account = account;
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
