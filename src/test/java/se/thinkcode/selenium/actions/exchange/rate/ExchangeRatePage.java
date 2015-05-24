package se.thinkcode.selenium.actions.exchange.rate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.thinkcode.selenium.steps.buy.currency.ResultPageException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ExchangeRatePage {
    private WebDriver browser;
    private float exchangeRate;

    public ExchangeRatePage() {
    }

    public ExchangeRatePage(WebDriver browser) {
        this.browser = browser;

        String expectedTitle = "Exchange rate result";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));

        // String exchangeRateMessage = getExchangeRateStringWebDriverWait();
        String exchangeRateMessage = getExchangeRateStringFluentWait();
        exchangeRate = parseResult(exchangeRateMessage);
    }

    private String getExchangeRateStringWebDriverWait() {
        WebDriverWait wait = new WebDriverWait(browser, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exchangeRate")));

        WebElement resultElement = browser.findElement(By.id("exchangeRate"));
        return resultElement.getText();
    }

    private String getExchangeRateStringFluentWait() {
        WebElement resultElement = new FluentWait<>(browser)
                .withTimeout(30, SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("exchangeRate")));

        return resultElement.getText();
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

    public float getExchangeRate() {
        return exchangeRate;
    }
}
