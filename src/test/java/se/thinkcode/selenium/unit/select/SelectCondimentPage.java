package se.thinkcode.selenium.unit.select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SelectCondimentPage {
    private final WebDriver browser;

    public SelectCondimentPage(WebDriver browser) {
        this.browser = browser;

        String expectedTitle = "Select condiment";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public String getSelectedCondiment() {
        WebElement condiments = browser.findElement(By.id("condiments"));
        Select select = new Select(condiments);

        WebElement selected = select.getFirstSelectedOption();

        return selected.getAttribute("value");
    }

    public void selectMilk() {
        WebElement condiments = browser.findElement(By.id("condiments"));
        Select select = new Select(condiments);

        select.selectByValue("milk");
    }

    public void selectSugar() {
        WebElement condiments = browser.findElement(By.id("condiments"));
        Select select = new Select(condiments);

        select.selectByValue("sugar");
    }

    public List<String> getAvailableCondiments() {
        WebElement condiments = browser.findElement(By.id("condiments"));
        Select select = new Select(condiments);

        List<WebElement> options = select.getOptions();

        List<String> stringOptions = new LinkedList<>();

        for (WebElement option : options) {
            String value = option.getAttribute("value");
            stringOptions.add(value);
        }

        return stringOptions;
    }
}
