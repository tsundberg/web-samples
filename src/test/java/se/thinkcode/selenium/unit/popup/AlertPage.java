package se.thinkcode.selenium.unit.popup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AlertPage {
    private final WebDriver browser;

    public AlertPage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl() + "alert.html";
        browser.get(page);

        String expectedTitle = "Java script alerts";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public void clickAlert() {
        WebElement alertButton = browser.findElement(By.id("alert"));
        alertButton.click();

        browser.switchTo().alert().accept();
    }

    public void confirm() {
        WebElement confirmationButton = browser.findElement(By.id("confirmation"));
        confirmationButton.click();

        browser.switchTo().alert().accept();
    }

    public void dismiss() {
        WebElement confirmationButton = browser.findElement(By.id("confirmation"));
        confirmationButton.click();

        browser.switchTo().alert().dismiss();
    }

    public void add_text_to_prompt(String response) {
        WebElement promptButton = browser.findElement(By.id("prompt"));
        promptButton.click();

        Alert dialogue = browser.switchTo().alert();
        dialogue.sendKeys(response);
        dialogue.accept();
    }

    public String getResult() {
        WebElement resultParagraph = browser.findElement(By.id("result"));

        return resultParagraph.getText();
    }
}
