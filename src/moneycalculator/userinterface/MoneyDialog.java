package moneycalculator.userinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;
import moneycalculator.model.Money;
import moneycalculator.model.Number;
import moneycalculator.persistence.CurrencySetLoader;

public class MoneyDialog {

    private Money money;

    public MoneyDialog() {
    }

    public Money getMoney() {
        return money;
    }

    public void execute() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                Number amount = Number.valueOf(readAmount(reader));
                Currency currency = CurrencySetLoader.load().getInstance().search(readCurrency(reader));
                this.money = new Money(amount, currency);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Error: No ha introducido un número");
            } catch (CurrencySet.CurrencyNotFoundException ex) {
                System.out.println(ex.getMessage());
            } 
        }
    }

    private static String readAmount(BufferedReader reader) throws IOException {
        System.out.print("Introduzca la cantidad de dinero: ");
        String amount = reader.readLine();
        return amount;
    }

    private static String readCurrency(BufferedReader reader) throws IOException {
        System.out.print("Introduzca el código de la divisa: ");
        String currency_code = reader.readLine();
        return currency_code;
    }
}
