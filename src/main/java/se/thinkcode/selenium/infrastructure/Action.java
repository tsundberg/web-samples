package se.thinkcode.selenium.infrastructure;

public class Action {
    private boolean buy = false;

    public Action(String action) {
        if (action.equalsIgnoreCase("buy")) {
            buy = true;
        }
    }

    public boolean isBuy() {
        return buy;
    }

    public String getAction() {
        if (isBuy()) {
            return "buy";
        }

        throw new UnknownActionException();
    }
}
