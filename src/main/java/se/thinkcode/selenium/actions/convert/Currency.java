package se.thinkcode.selenium.actions.convert;

public class Currency {
    private String currency;

    public Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != getClass()) {
            return false;
        }
        Currency rhs = (Currency) o;
        return currency.equals(rhs.currency);
    }

    @Override
    public int hashCode() {
        return currency.hashCode();
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currency='" + currency + '\'' +
                '}';
    }
}