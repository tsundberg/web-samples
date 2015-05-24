package se.thinkcode.selenium.unit.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.thinkcode.selenium.bdd.steps.password.ConfirmationPage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RequestNewPasswordPage {
    private WebDriver browser;
    private String account;

    public RequestNewPasswordPage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl() + "requestPassword.html";
        browser.get(page);


        String expectedTitle = "Request new password";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public ConfirmPasswordSentPage requestNewPassword(String account) {
        WebElement accountField = browser.findElement(By.id("account"));
        accountField.sendKeys(account);

        accountField.submit();

        return new ConfirmPasswordSentPage(browser);
    }
}
