package moneycalculator.control;

import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.userinterface.MoneyCalculatorDialogInterface;

public class ExchangeMoneyControl {

    private Currency toCurrency;
    private Money money;
    private MoneyCalculatorDialogInterface moneyDialog;

    public ExchangeMoneyControl(MoneyCalculatorDialogInterface moneyDialog) {
        this.moneyDialog = moneyDialog;
    }

    public void execute() {
        moneyDialog.execute();
        money = moneyDialog.getMoney();
        toCurrency = moneyDialog.getCurrency();
        //moneyDialog.show();
//        ExchangeRateLoader loader = new ExchangeRateLoader();
    }
}
