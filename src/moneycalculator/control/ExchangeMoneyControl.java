package moneycalculator.control;

import moneycalculator.UI.ApplicationFrame;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.persistence.ExchangeRateLoader;

public class ExchangeMoneyControl {

    private Currency toCurrency;
    private Money money;
    private ApplicationFrame frame;
    private ExchangeRateLoader loader;

    public ExchangeMoneyControl(ApplicationFrame frame, ExchangeRateLoader loader) {
        this.frame = frame;
        this.loader = loader;
    }

    public void execute() {
        frame.execute();
    }
}
