package se.thinkcode.selenium.actions.exchange.rate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.thinkcode.selenium.WrongPageException;

import java.util.Currency;

public class RequestExchangeRatePage {
    private final WebDriver browser;

    public RequestExchangeRatePage(WebDriver browser) {
        this.browser = browser;

        browser.get("http://localhost:8080/exchangeRate.html");

        String title = browser.getTitle();
        String expectedTitle = "Exchange rate";

        if (!title.equals(expectedTitle)) {
            throw new WrongPageException(title, expectedTitle);
        }
    }

    public ExchangeRatePage getExchangeRate(Currency from, Currency to) {
        WebElement fromField = browser.findElement(By.name("from"));
        fromField.sendKeys(from.getSymbol());

        WebElement toField = browser.findElement(By.name("to"));
        toField.sendKeys(to.getSymbol());

        fromField.submit();

        return new ExchangeRatePage(browser);
    }
}
