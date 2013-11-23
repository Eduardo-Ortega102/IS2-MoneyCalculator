package moneycalculator.model;

import java.util.ArrayList;
import java.util.HashSet;

public class CurrencySet extends HashSet<Currency> {

    private static CurrencySet instance;

    private CurrencySet() {
    }

    public static CurrencySet getInstance() {
        if (instance == null) {
            instance = new CurrencySet();
        }
        return instance;
    }

    public Currency get(String code) throws CurrencyNotFoundException {
        for (Currency currency : this) {
            if (currency.getCode().equalsIgnoreCase(code)) {
                return currency;
            }
        }
        throw new CurrencyNotFoundException("Error: Currency code not found");
    }

    public Currency search(String string) throws CurrencyNotFoundException, MultipleCurrencyException {
        for (Currency currency : this) {
            if (currency.getCode().equalsIgnoreCase(string)) return currency;
            if (currency.getSymbol().equalsIgnoreCase(string)) return currency;
            if (currency.getName().equalsIgnoreCase(string)) return currency;
            if (currency.getName().toLowerCase().contains(string.toLowerCase())) {
                Currency[] list = currencyList(string);
                if (list.length == 1) {
                    return list[0];
                } else {
                    System.out.println("Divisas disponibles: ");
                    for (int i = 0; i < list.length; i++) {
                        System.out.println("--------------------" + list[i]);
                    }
                    throw new MultipleCurrencyException();
                }
            }
        }
        throw new CurrencyNotFoundException("Error: Currency not found");
    }

    private Currency[] currencyList(String string) {
        ArrayList<Currency> list = new ArrayList<>();
        for (Currency currency : this) {
            if (currency.getName().toLowerCase().contains(string.toLowerCase()))
                list.add(currency);
        }
        return list.toArray(new Currency[0]);
    }

    public static class CurrencyNotFoundException extends Exception {

        public CurrencyNotFoundException(String message) {
            super(message);
        }
    }

    public static class MultipleCurrencyException extends Exception {

        public MultipleCurrencyException() {
        }
    }
}
