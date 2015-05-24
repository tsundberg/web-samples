package se.thinkcode.selenium.bdd.steps.password;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RequestPage {
    private WebDriver browser;
    private String account;

    public RequestPage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl() + "requestPassword.html";
        browser.get(page);


        String expectedTitle = "Request new password";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
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
