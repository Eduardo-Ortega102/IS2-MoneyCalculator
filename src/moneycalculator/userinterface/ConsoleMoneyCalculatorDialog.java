package moneycalculator.userinterface;

import java.io.BufferedReader;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.userinterface.console.ConsoleCurrencyDialog;
import moneycalculator.userinterface.console.ConsoleMoneyDialog;

public class ConsoleMoneyCalculatorDialog implements MoneyCalculatorDialogInterface {

    private BufferedReader reader;
    private Currency currency;
    private Money money;

    public ConsoleMoneyCalculatorDialog(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public Money getMoney() {
        return money;
    }

    @Override
    public void execute() {
        ConsoleMoneyDialog moneyDialog = new ConsoleMoneyDialog(reader);
        moneyDialog.execute("Introduzca la divisa inicial: ");
        ConsoleCurrencyDialog currencyDialog = new ConsoleCurrencyDialog(reader);
        currencyDialog.execute("Introduzca la divisa a la que convertir: ");
        this.money = moneyDialog.getMoney();
        this.currency = currencyDialog.getCurrency();
    }

//    @Override
//    public void show() {
//        System.out.println("Not supported yet.");
//    }
}
