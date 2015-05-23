package se.thinkcode.selenium.steps.buy.currency;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.thinkcode.selenium.WrongPageException;
import se.thinkcode.selenium.actions.buy.currency.Currency;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultPage {
    private WebDriver browser;
    private int cost;
    private Currency currency;

    public ResultPage(WebDriver browser) {
        this.browser = browser;
        String actualTitle = browser.getTitle();
        String expectedTitle = "Buy currency result";

        if (!actualTitle.equals(expectedTitle)) {
            throw new WrongPageException(actualTitle, expectedTitle);
        }

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
            currency = new Currency(currencyString);
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
