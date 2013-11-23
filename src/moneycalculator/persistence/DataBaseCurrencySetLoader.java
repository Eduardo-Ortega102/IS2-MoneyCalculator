package moneycalculator.persistence;

import moneycalculator.model.CurrencySet;

public class DataBaseCurrencySetLoader implements CurrencySetLoader {

    private static DataBaseCurrencySetLoader instance;

    private DataBaseCurrencySetLoader() {
    }

    public static CurrencySetLoader getInstance() {
        if (instance == null) {
            instance = new DataBaseCurrencySetLoader();
        }
        return instance;
    }

    @Override
    public void load() {
        CurrencySet set = CurrencySet.getInstance();

    }
}
