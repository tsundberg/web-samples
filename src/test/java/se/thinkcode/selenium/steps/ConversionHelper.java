package se.thinkcode.selenium.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.Main;
import se.thinkcode.selenium.actions.convert.Action;
import se.thinkcode.selenium.actions.convert.Currency;

public class ConversionHelper {
    private final Action action;
    private final int amount;
    private final Currency to;
    private final Currency from;

    private WebDriver browser = new FirefoxDriver();
    private ResultPage resultPage;

    public ConversionHelper(Action action, int amount, Currency to, Currency from) {
        this.action = action;
        this.amount = amount;
        this.to = to;
        this.from = from;

        startApplication();

        convert();
    }

    private void startApplication() {
        String[] args = {};
        Main.main(args);
    }

    public void convert() {
        ConversionPage conversionPage = new ConversionPage(browser);

        conversionPage.selectAction(action);
        conversionPage.selectWantedCurrency(to);
        conversionPage.setWantedAmount(amount);
        conversionPage.selectCurrencyToPayWith(from);
        resultPage = conversionPage.submitForm();
    }

    public int getCost() {
        return resultPage.getCost();
    }

    public Currency getFromCurrency() {
        return resultPage.getFromCurrency();
    }
}