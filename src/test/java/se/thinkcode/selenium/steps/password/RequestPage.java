package se.thinkcode.selenium.steps.password;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.thinkcode.selenium.steps.WrongPageException;

public class RequestPage {
    private WebDriver browser;
    private String account;

    public RequestPage(WebDriver browser) {
        this.browser = browser;
        browser.get("http://localhost:8080/requestPassword.html");

        String title = browser.getTitle();

        if (!title.equals("Request new password")) {
            throw new WrongPageException();
        }
    }

    public void enterAccountName(String account) {
        this.account = account;
    }

    public ConfirmationPage submitRequest() {
        WebElement accountField = browser.findElement(By.id("account"));
        accountField.sendKeys(account);

        accountField.submit();

        return new ConfirmationPage(browser);
    }
}
