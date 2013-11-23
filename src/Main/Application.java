package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import moneycalculator.control.ExchangeMoneyControl;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;
import moneycalculator.model.Number;
import moneycalculator.persistence.CurrencySetLoader;
import moneycalculator.persistence.DataBaseCurrencySetLoader;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.userinterface.ConsoleMoneyCalculator;
import moneycalculator.userinterface.DialogInterface;
import moneycalculator.userinterface.SwingMoneyCalculator;

public class Application {

    public static void main(String[] args) throws IOException {
        //numberTest()
        CurrencySetLoader currencySetLoader = createCurrencySetLoader();
        currencySetLoader.load();
        ExchangeMoneyControl moneyControl = new ExchangeMoneyControl(createDialog(), createExchangeRateLoader());
        while (true) {
            moneyControl.execute();
        }

    }

    private static ExchangeRateLoader createExchangeRateLoader() {
        return new ExchangeRateLoader();
    }

    private static DialogInterface createDialog() {
//        return new ConsoleMoneyCalculator(new BufferedReader(new InputStreamReader(System.in)));
        return new SwingMoneyCalculator();
    }

    private static CurrencySetLoader createCurrencySetLoader() {
        return new CurrencySetLoader() {
            @Override
            public void load() {
                CurrencySet set = CurrencySet.getInstance();
                set.add(new Currency("EUR", "Euro", "€"));
                set.add(new Currency("GBP", "Libra esterlina", "£"));
                set.add(new Currency("USD", "Dolar americano", "$"));
                set.add(new Currency("CAD", "Dolar canadiense", "C$"));
                set.add(new Currency("HKD", "Dolar de Hong Kong", "HK$"));
                set.add(new Currency("GNF", "Franco guineano", "FG"));
                set.add(new Currency("JPY", "Yen", "¥"));
                set.add(new Currency("KES", "Chelín keniano", "KSh"));
                set.add(new Currency("ISK", "Corona islandesa", "kri"));
                set.add(new Currency("HNL", "Lempira", "L"));
                set.add(new Currency("EGP", "Libra egipcia", "LE"));
                set.add(new Currency("DKK", "Corona danesa", "krd"));
            }
        };
    }

    private static void numberTest() {
        Number number1 = new Number(2, 6);
        Number number2 = new Number(1, 3);
        Number number3 = new Number(5, 2);
        Number number4 = new Number(25, 100);
        Number number5 = new Number(number4);
        Number number6 = new Number(0.5);
        Number number7 = new Number(2.5);
        Number number8 = Number.valueOf("200.15");
        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);
        System.out.println(number4);
        System.out.println(number5);
        System.out.println(number5.equals(number4));
        System.out.println(number6);
        System.out.println(number7);
        System.out.println(number8.equals(number7));
    }
}
