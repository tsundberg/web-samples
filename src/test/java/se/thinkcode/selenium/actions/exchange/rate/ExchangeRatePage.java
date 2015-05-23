package se.thinkcode.selenium.actions.exchange.rate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.thinkcode.selenium.WrongPageException;
import se.thinkcode.selenium.steps.buy.currency.ResultPageException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExchangeRatePage {
    private WebDriver browser;
    private float exchangeRate;

    public ExchangeRatePage() {
    }

    public ExchangeRatePage(WebDriver browser) {
        this.browser = browser;

        String title = browser.getTitle();
        String expectedTitle = "Exchange rate result";

        if (!title.equals(expectedTitle)) {
            throw new WrongPageException(title, expectedTitle);
        }

        parseExchangeRate();
    }

    private void parseExchangeRate() {
        WebDriverWait wait = new WebDriverWait(browser, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exchangeRate")));

        WebElement resultElement = browser.findElement(By.id("exchangeRate"));
        String result = resultElement.getText();

        exchangeRate = parseResult(result);
    }

    float parseResult(String result) {
        Pattern p = Pattern.compile(".* is (.*)");
        Matcher m = p.matcher(result);
        if (m.matches()) {
            String value = m.group(1);
            return Float.parseFloat(value);
        } else {
            throw new ResultPageException();
        }
    }

    public float getConversionRate() {
        return exchangeRate;
    }
}
