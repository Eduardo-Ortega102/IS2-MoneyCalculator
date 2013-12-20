package moneycalculator.control;

import moneycalculator.UI.CurrencyDialog;
import moneycalculator.UI.MoneyDialog;
import moneycalculator.UI.MoneyViewer;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.model.MoneyAmount;
import moneycalculator.persistence.ExchangeRateLoader;

public class CalculateCommand extends Command {

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final MoneyViewer viewer;
    private final ExchangeRateLoader loader;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog,
            MoneyViewer viewer, ExchangeRateLoader loader) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.viewer = viewer;
        this.loader = loader;
    }

    @Override
    public void execute() {
        viewer.showMoney(getSourceAmount(), getFromCurrency(), getMoney());
    }

    private MoneyAmount getSourceAmount() {
        return moneyDialog.getMoney().getAmount();
    }

    private Currency getFromCurrency() {
        return moneyDialog.getMoney().getCurrency();
    }

    private Money getMoney() {
        return new Money(getNewAmount(), getToCurrency());
    }

    private MoneyAmount getNewAmount() {
        return new MoneyAmount(getSourceAmount().multiplicate(getExchangeRate()));
    }

    private MoneyAmount getExchangeRate() {
        return loader.load(getFromCurrency(), getToCurrency()).getRate();
    }

    private Currency getToCurrency() {
        return currencyDialog.getCurrency();
    }
}
