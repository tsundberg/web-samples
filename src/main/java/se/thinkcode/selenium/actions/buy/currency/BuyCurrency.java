package se.thinkcode.selenium.actions.buy.currency;

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
        Converter converter = new Converter(action, amount, to, from);
        return converter.getCost();
    }
}
