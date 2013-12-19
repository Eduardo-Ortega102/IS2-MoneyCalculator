package moneycalculator.control;

import moneycalculator.UI.CurrencyDialog;
import moneycalculator.UI.MoneyDialog;
import moneycalculator.UI.MoneyViewer;
import moneycalculator.model.Money;
import moneycalculator.model.MoneyAmount;

public class CalculateCommand extends Command {
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final MoneyViewer viewer;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyViewer viewer) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.viewer = viewer;
    }

    @Override
    public void execute() {
        viewer.showMoney(new Money(getAmount(), currencyDialog.getCurrency()));
    }

    private MoneyAmount getAmount() {
        return new MoneyAmount(moneyDialog.getMoney().getAmount().multiplicate(getExchangeRate()));
    }

    private double getExchangeRate() {
        return 2;
    }
    
    
        

}
