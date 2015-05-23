package se.thinkcode.selenium.steps.buy.currency;

import se.thinkcode.selenium.actions.buy.currency.Action;
import se.thinkcode.selenium.actions.buy.currency.Currency;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import se.thinkcode.selenium.steps.WrongPageException;

public class BuyCurrencyPage {
    private WebDriver browser;

    public BuyCurrencyPage(WebDriver browser) {
        this.browser = browser;
        browser.get("http://localhost:8080/buyCurrency.html");

        String title = browser.getTitle();

        if (!title.equals("Buy currency")) {
            throw new WrongPageException();
        }
    }

    public void selectAction(Action action) {
        WebElement radioButton = browser.findElement(By.id(action.getAction()));
        radioButton.click();
    }

    public void selectWantedCurrency(Currency to) {
        WebElement selectElement = browser.findElement(By.id("toCurrency"));
        Select select = new Select(selectElement);

        select.selectByValue(to.getCurrency());
    }

    public WebElement setWantedAmount(int amount) {
        WebElement amountField = browser.findElement(By.id("amount"));
        amountField.sendKeys("" + amount);

        return amountField;
    }

    public void selectCurrencyToPayWith(Currency from) {
        WebElement selectElement = browser.findElement(By.id("fromCurrency"));
        Select select = new Select(selectElement);

        select.selectByValue(from.getCurrency());
    }

    public ResultPage submitForm() {
        WebElement form = browser.findElement(By.id("orderCurrency"));
        form.submit();

        return new ResultPage(browser);
    }
}
