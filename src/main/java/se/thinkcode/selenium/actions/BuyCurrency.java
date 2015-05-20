package se.thinkcode.selenium.actions;

import se.thinkcode.selenium.infrastructure.Action;
import se.thinkcode.selenium.infrastructure.Conversion;
import se.thinkcode.selenium.model.Currency;

public class BuyCurrency {
    private final Action action;
    private final int amount;
    private final Currency to;
    private final Currency from;

    public BuyCurrency(Action action, int amount, Currency to, Currency from) {
        this.action = action;
        this.amount = amount;
        this.to = to;
        this.from = from;
    }

    public int getCost() {
        Conversion conversion = new Conversion(action, amount, to, from);
        return conversion.getCost();
    }
}
