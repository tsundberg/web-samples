package se.thinkcode.selenium.unit.radiobutton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SelectBeveragePage {
    private final WebDriver browser;

    public SelectBeveragePage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl() + "selectBeverage.html";
        browser.get(page);

        String expectedTitle = "Select beverage";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public String getSelectedBeverage() {
        List<WebElement> beverages = browser.findElements(By.name("beverage"));

        for (WebElement radioButton : beverages) {
            if (radioButton.isSelected()) {
                return radioButton.getAttribute("value");
            }
        }

        return "";
    }

    public void selectCoffee() {
        List<WebElement> beverages = browser.findElements(By.name("beverage"));

        for (WebElement radioButton : beverages) {
            if (radioButton.getAttribute("value").equals("coffee")) {
                radioButton.click();
            }
        }
    }

    public void selectTea() {
        List<WebElement> beverages = browser.findElements(By.name("beverage"));

        for (WebElement radioButton : beverages) {
            if (radioButton.getAttribute("value").equals("tea")) {
                radioButton.click();
            }
        }

    }

    public List<String> getAvailableBeverages() {
        List<WebElement> beverages = browser.findElements(By.name("beverage"));
        List<String> availableBeverages = new LinkedList<>();

        for (WebElement radioButton : beverages) {
            String beverage = radioButton.getAttribute("value");
            availableBeverages.add(beverage);
        }

        return availableBeverages;
    }
}
