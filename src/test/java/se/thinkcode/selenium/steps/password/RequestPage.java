package se.thinkcode.selenium.steps.password;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.thinkcode.selenium.WrongPageException;

public class RequestPage {
    private WebDriver browser;
    private String account;

    public RequestPage(WebDriver browser) {
        this.browser = browser;
        browser.get("http://localhost:8080/requestPassword.html");

        String actualTitle = browser.getTitle();
        String expectedTitle = "Request new password";

        if (!actualTitle.equals(expectedTitle)) {
            throw new WrongPageException(actualTitle, expectedTitle);
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
