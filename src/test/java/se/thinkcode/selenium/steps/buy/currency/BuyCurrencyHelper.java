package se.thinkcode.selenium.steps.buy.currency;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.actions.buy.currency.Action;
import se.thinkcode.selenium.actions.buy.currency.Currency;

public class BuyCurrencyHelper {
    private final Action action;
    private final int amount;
    private final Currency to;
    private final Currency from;

    private WebDriver browser = new FirefoxDriver();
    private ResultPage resultPage;

    public BuyCurrencyHelper(Action action, int amount, Currency to, Currency from) {
        this.action = action;
        this.amount = amount;
        this.to = to;
        this.from = from;
    }

    public void convert() {
        BuyCurrencyPage conversionPage = new BuyCurrencyPage(browser);

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