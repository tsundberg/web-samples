package se.thinkcode.selenium.unit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.thinkcode.selenium.unit.checkbox.SelectColorPage;
import se.thinkcode.selenium.unit.popup.AlertPage;
import se.thinkcode.selenium.unit.select.SelectCondimentPage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IndexPage {
    private final WebDriver browser;

    public IndexPage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl();
        browser.get(page);

        String expectedTitle = "Index";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public SelectColorPage selectColor() {
        WebElement selectedCondiment = browser.findElement(By.id("selectColor"));
        selectedCondiment.click();

        return new SelectColorPage(browser);
    }

    public SelectCondimentPage selectCondiment() {
        WebElement selectedCondiment = browser.findElement(By.id("selectCondiment"));
        selectedCondiment.click();

        return new SelectCondimentPage(browser);
    }

    public AlertPage alert() {
        WebElement selectedCondiment = browser.findElement(By.id("alert"));
        selectedCondiment.click();

        return new AlertPage(browser);
    }

}
