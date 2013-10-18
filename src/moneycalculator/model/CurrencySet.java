package moneycalculator.model;

import java.util.HashSet;

public class CurrencySet extends HashSet<Currency>{
    private static CurrencySet instance;

    private CurrencySet() {
    }
    
    public static CurrencySet getInstance(){
        if (instance == null)
            instance = new CurrencySet();
        return instance;
    }
    
    public Currency search(String code) throws CurrencyNotFoundException{
        for (Currency currency : this) {
            if (currency.getCode().equalsIgnoreCase(code)) {
                return currency;
            }
        }
        throw new CurrencyNotFoundException("Error: Currency code not found");
    }

    public static class CurrencyNotFoundException extends Exception {

        public CurrencyNotFoundException(String message) {
            super(message);
        }
    }
    
    
}
