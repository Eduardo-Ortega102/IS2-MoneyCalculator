package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import moneycalculator.control.ExchangeMoneyControl;
import moneycalculator.model.CurrencySet;
import moneycalculator.model.Number;
import moneycalculator.persistence.CurrencySetLoader;
import moneycalculator.userinterface.ConsoleMoneyCalculatorDialog;
import moneycalculator.userinterface.MoneyCalculatorDialogInterface;
import moneycalculator.userinterface.SwingMoneyCalculatorDialog;

public class Application {

    public static void main(String[] args) throws IOException {
        //numberTest()
        CurrencySet currencySet = CurrencySetLoader.load();
        ExchangeMoneyControl moneyControl = new ExchangeMoneyControl(createMoneyCalculatorDialog());

        while (true) {
            moneyControl.execute();
        }

    }

    private static MoneyCalculatorDialogInterface createMoneyCalculatorDialog() {
//        return new ConsoleMoneyCalculatorDialog(new BufferedReader(new InputStreamReader(System.in)));
        return new SwingMoneyCalculatorDialog();
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
