package moneycalculator.persistence;

import moneycalculator.model.CurrencySet;
import moneycalculator.model.Currency;

public class CurrencySetLoader {
  
        public static CurrencySet load(){
            CurrencySet set = CurrencySet.getInstance();
            set.add(new Currency("USD", "Dolar americano", "$"));
            set.add(new Currency("EUR", "Euro", "€"));
            set.add(new Currency("GBP", "Libra esterlina", "£"));
            return set;
        }
}
