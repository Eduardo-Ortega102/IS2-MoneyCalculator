package moneycalculator.model;

import java.util.Date;

public class ExchangeRate {

    private Date date;
    private Currency fromCurrency;
    private Currency toCurrency;
    private Number rate;

    public ExchangeRate(Currency fromCurrency, Currency toCurrency) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public Date getDate() {
        return date;
    }

    public Number getRate() {
        return rate;
    }
}
