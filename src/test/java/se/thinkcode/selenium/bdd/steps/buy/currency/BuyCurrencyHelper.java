package se.thinkcode.selenium.bdd.steps.buy.currency;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.TestHelper;
import se.thinkcode.selenium.actions.buy.currency.Action;

import java.util.Currency;

public class BuyCurrencyHelper {
    private final Action action;
    private final int amount;
    private final Currency to;
    private final Currency from;

    private WebDriver browser;
    private ResultPage resultPage;

    public BuyCurrencyHelper(Action action, int amount, Currency to, Currency from) {
        this.action = action;
        this.amount = amount;
        this.to = to;
        this.from = from;

        browser = TestHelper.getDefaultBrowser();
        String baseUrl = TestHelper.getBaseUrl();
        browser.get(baseUrl);
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