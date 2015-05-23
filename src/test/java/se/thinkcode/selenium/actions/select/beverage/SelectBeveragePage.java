package se.thinkcode.selenium.actions.select.beverage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.thinkcode.selenium.WrongPageException;

import java.util.LinkedList;
import java.util.List;

public class SelectBeveragePage {
    private final WebDriver browser;

    public SelectBeveragePage(WebDriver browser) {
        this.browser = browser;
        browser.get("http://localhost:8080/selectBeverage.html");

        String title = browser.getTitle();
        String expectedTitle = "Select beverage";

        if (!title.equals(expectedTitle)) {
            throw new WrongPageException(title, expectedTitle);
        }

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
