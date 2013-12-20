package moneycalculator.persistence;

import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.MoneyAmount;

public class DataBaseExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Currency from, Currency to){
        return new ExchangeRate(from, to, new MoneyAmount(2));
    }
}
