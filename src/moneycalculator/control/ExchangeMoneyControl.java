package moneycalculator.control;

import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.model.Number;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.userinterface.DialogInterface;

public class ExchangeMoneyControl {

    private Currency toCurrency;
    private Money money;
    private DialogInterface moneyDialog;
    private ExchangeRateLoader loader;

    public ExchangeMoneyControl(DialogInterface moneyDialog, ExchangeRateLoader loader) {
        this.moneyDialog = moneyDialog;
        this.loader = loader;
    }

    public void execute() {
        moneyDialog.execute();
        money = moneyDialog.getMoney();
        toCurrency = moneyDialog.getCurrency();
        moneyDialog.viewResult(new Money(new Number(20),toCurrency));
    }
}
