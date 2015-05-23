package se.thinkcode.selenium.actions.exchange.rate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Currency;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RequestExchangeRatePage {
    private final WebDriver browser;

    public RequestExchangeRatePage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl() + "/exchangeRate.html";
        browser.get(page);

        String actualTitle = browser.getTitle();
        String expectedTitle = "Exchange rate";

        assertThat(actualTitle, is(expectedTitle));
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
