package moneycalculator.userinterface.console;

import java.io.BufferedReader;
import java.io.IOException;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class ConsoleCurrencyDialog {

    private BufferedReader reader;
    private Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public ConsoleCurrencyDialog(BufferedReader reader) {
        this.reader = reader;
    }

    public void execute(String message) {
        while (true) {
            try {
                this.currency = CurrencySet.getInstance().search(readCurrency(reader, message));
                break;
            } catch (CurrencySet.CurrencyNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (CurrencySet.MultipleCurrencyException ex) {
            } catch (IOException ex) {
                System.out.println("An exception has been catched.");
            }
        }
    }

    private String readCurrency(BufferedReader reader, String string) throws IOException {
        System.out.print(string);
        String currencyReaded = reader.readLine();
        return currencyReaded;
    }
}
