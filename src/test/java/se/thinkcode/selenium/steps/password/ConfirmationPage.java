package se.thinkcode.selenium.steps.password;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.thinkcode.selenium.steps.WrongPageException;

public class ConfirmationPage {
    private WebDriver browser;
    private String confirmationMessage;

    public ConfirmationPage(WebDriver browser) {
        this.browser = browser;

        String title = browser.getTitle();

        if (!title.equals("Confirm new password request")) {
            throw new WrongPageException();
        }

        parseResult();
        browser.quit();
    }

    private void parseResult() {
        WebElement resultElement = browser.findElement(By.id("confirmation"));
        confirmationMessage = resultElement.getText();
    }

    public String getConfirmationMessage() {
        return confirmationMessage;
    }
}
