package moneycalculator.UI;

import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.model.Number;

public interface MoneyViewer {
    
    public void showMoney(Number amount, Currency fromCurrency, Money money);

}
