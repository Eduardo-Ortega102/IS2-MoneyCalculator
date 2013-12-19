package moneycalculator.UI;

public interface ApplicationFrame {
    
    public void execute();

    public MoneyDialog getMoneyDialog();

    public MoneyViewer getMoneyViewer();

    public CurrencyDialog getCurrencyDialog();
}
