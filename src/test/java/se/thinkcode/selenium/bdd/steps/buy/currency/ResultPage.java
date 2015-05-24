package se.thinkcode.selenium.bdd.steps.buy.currency;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Currency;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ResultPage {
    private WebDriver browser;
    private int cost;
    private Currency currency;

    public ResultPage(WebDriver browser) {
        this.browser = browser;

        String expectedTitle = "Buy currency result";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));

        parseResult();
        browser.quit();
    }

    private void parseResult() {
        WebElement resultElement = browser.findElement(By.id("result"));
        String result = resultElement.getText();

        Pattern p = Pattern.compile("[\\w ]+ (\\d+) (\\w+)\\.");
        Matcher m = p.matcher(result);
        if (m.matches()) {
            String value = m.group(1);
            cost = Integer.parseInt(value);

            String currencyString = m.group(2);
            currency = Currency.getInstance(currencyString);
        } else {
            throw new ResultPageException();
        }
    }

    public int getCost() {
        return cost;
    }

    public Currency getFromCurrency() {
        return currency;
    }
}
