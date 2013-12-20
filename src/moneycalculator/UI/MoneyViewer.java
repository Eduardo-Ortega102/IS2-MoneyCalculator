package moneycalculator.UI;

import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.model.MoneyAmount;

public interface MoneyViewer {
    
    public void showMoney(MoneyAmount amount, Currency fromCurrency, Money money);

}
