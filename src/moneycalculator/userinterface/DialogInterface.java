package moneycalculator.userinterface;

import moneycalculator.model.Currency;
import moneycalculator.model.Money;

public interface DialogInterface {

    public void execute();
    
    public void viewResult(Money moneyResult);

    public Currency getCurrency();

    public Money getMoney();
}