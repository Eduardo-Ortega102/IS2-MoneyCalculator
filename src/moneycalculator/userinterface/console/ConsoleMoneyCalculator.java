package moneycalculator.userinterface.console;

import java.io.BufferedReader;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;

public class ConsoleMoneyCalculator  {

    private BufferedReader reader;
    private Currency currency;
    private Money money;

    public ConsoleMoneyCalculator(BufferedReader reader) {
        this.reader = reader;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Money getMoney() {
        return money;
    }

    public void execute() {
        ConsoleMoneyDialog moneyDialog = new ConsoleMoneyDialog(reader);
        moneyDialog.execute("Introduzca la divisa inicial: ");
        ConsoleCurrencyDialog currencyDialog = new ConsoleCurrencyDialog(reader);
        currencyDialog.execute("Introduzca la divisa a la que convertir: ");
        this.money = moneyDialog.getMoney();
        this.currency = currencyDialog.getCurrency();
    }

    public void viewResult(Money moneyResult) {
        System.out.println(money.toString() + " son " + moneyResult.toString());
    }
}
