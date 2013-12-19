package moneycalculator.model;

public class Money {

    private MoneyAmount amount;
    private Currency currency;

    public Money(MoneyAmount amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public MoneyAmount getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
    
    
}
