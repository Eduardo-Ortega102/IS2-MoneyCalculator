package moneycalculator.persistence;

import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class MockCurrencySetLoader implements CurrencySetLoader {

    @Override
    public void load() throws Exception {
        CurrencySet set = CurrencySet.getInstance();
        set.add(new Currency("EUR", "Euro", "€"));
        set.add(new Currency("GBP", "Libra esterlina", "£"));
        set.add(new Currency("USD", "Dolar americano", "$"));
        set.add(new Currency("CAD", "Dolar canadiense", "C$"));
        set.add(new Currency("HKD", "Dolar de Hong Kong", "HK$"));
        set.add(new Currency("GNF", "Franco guineano", "FG"));
        set.add(new Currency("JPY", "Yen", "¥"));
        set.add(new Currency("KES", "Chelín keniano", "KSh"));
        set.add(new Currency("ISK", "Corona islandesa", "kri"));
        set.add(new Currency("HNL", "Lempira", "L"));
        set.add(new Currency("EGP", "Libra egipcia", "LE"));
        set.add(new Currency("DKK", "Corona danesa", "krd"));
    }
}
