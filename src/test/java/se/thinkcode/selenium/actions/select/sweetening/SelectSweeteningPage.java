package se.thinkcode.selenium.actions.select.sweetening;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SelectSweeteningPage {
    private final WebDriver browser;

    public SelectSweeteningPage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl() + "selectSweetener.html";
        browser.get(page);

        String expectedTitle = "Select sweetener";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public String getSelectedSweetening() {
        WebElement sweeteners = browser.findElement(By.id("sweeteners"));
        Select select = new Select(sweeteners);

        WebElement selected = select.getFirstSelectedOption();

        return selected.getAttribute("value");
    }

    public void selectMilk() {
        WebElement sweeteners = browser.findElement(By.id("sweeteners"));
        Select select = new Select(sweeteners);

        select.selectByValue("milk");
    }

    public void selectSugar() {
        WebElement sweeteners = browser.findElement(By.id("sweeteners"));
        Select select = new Select(sweeteners);

        select.selectByValue("sugar");
    }

    public List<String> getAvailableSweeteners() {
        WebElement sweeteners = browser.findElement(By.id("sweeteners"));
        Select select = new Select(sweeteners);

        List<WebElement> options = select.getOptions();

        List<String> stringOptions = new LinkedList<>();

        for (WebElement option : options) {
            String value = option.getAttribute("value");
            stringOptions.add(value);
        }

        return stringOptions;
    }
}
