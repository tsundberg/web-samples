package se.thinkcode.selenium.steps;

import se.thinkcode.selenium.Main;
import se.thinkcode.selenium.infrastructure.Action;
import se.thinkcode.selenium.model.Currency;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

        allowServerTimeToStart();
    }

    private void allowServerTimeToStart() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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