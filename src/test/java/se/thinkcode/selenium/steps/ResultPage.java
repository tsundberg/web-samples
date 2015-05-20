package se.thinkcode.selenium.steps;

import se.thinkcode.selenium.model.Currency;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultPage {
    private WebDriver browser;
    private int cost;
    private Currency currency;

    public ResultPage(WebDriver browser) {
        this.browser = browser;
        String title = browser.getTitle();
        if(!title.equals("Convert currency result")) {
            throw new WrongPageException();
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
