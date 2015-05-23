package se.thinkcode.selenium.steps.password;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.thinkcode.selenium.WrongPageException;

public class ConfirmationPage {
    private WebDriver browser;
    private String confirmationMessage;

    public ConfirmationPage(WebDriver browser) {
        this.browser = browser;

        String actualTitle = browser.getTitle();
        String expectedTitle = "Confirm new password request";

        if (!actualTitle.equals(expectedTitle)) {
            throw new WrongPageException(actualTitle, expectedTitle);
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
