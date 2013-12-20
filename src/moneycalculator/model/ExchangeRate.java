package moneycalculator.model;

public class ExchangeRate {

    private Currency fromCurrency;
    private Currency toCurrency;
    private MoneyAmount rate;

    public ExchangeRate(Currency fromCurrency, Currency toCurrency, MoneyAmount rate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public MoneyAmount getRate() {
        return rate;
    }
}
