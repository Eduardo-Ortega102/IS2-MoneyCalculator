package moneycalculator.userinterface.console;

import java.io.BufferedReader;
import java.io.IOException;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.model.Number;

public class ConsoleMoneyDialog {

    private BufferedReader reader;
    private Money money;

    public Money getMoney() {
        return money;
    }

    public ConsoleMoneyDialog(BufferedReader reader) {
        this.reader = reader;
    }

    public void execute(String message) {
        Number amount;
        ConsoleCurrencyDialog currencyDialog = new ConsoleCurrencyDialog(reader);
        Currency currency;
        while (true) {
            try {
                amount = Number.valueOf(readAmount(reader));
                currencyDialog.execute(message);
                currency = currencyDialog.getCurrency();
                this.money = new Money(amount, currency);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Error: No ha introducido un número");
            } catch (IOException ex) {
                System.out.println("An exception has been catched.");
            }
        }
    }

    private static String readAmount(BufferedReader reader) throws IOException {
        System.out.print("Introduzca la cantidad de dinero: ");
        String amount = reader.readLine();
        return amount;
    }
}
