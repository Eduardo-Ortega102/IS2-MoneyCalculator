package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import moneycalculator.UI.ApplicationFrame;
import moneycalculator.UI.swing.ActionListenerFactory;
import moneycalculator.UI.swing.SwingApplicationFrame;
import moneycalculator.control.CalculateCommand;
import moneycalculator.control.Command;
import moneycalculator.control.MoneyCalculatorControl;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;
import moneycalculator.model.MoneyAmount;
import moneycalculator.persistence.CurrencySetLoader;
import moneycalculator.persistence.DataBaseExchangeRateLoader;
import moneycalculator.persistence.ExchangeRateLoader;

public class Application {

    private HashMap<String, Command> commandMap;

    public static void main(String[] args) throws IOException {
        new Application().execute();
    }

    private void execute() {
        CurrencySetLoader currencySetLoader = createCurrencySetLoader();
        currencySetLoader.load();
        ApplicationFrame frame = createApplicationFrame();
        ExchangeRateLoader exchangeRate = createExchangeRateLoader();
        this.createCommands(frame, exchangeRate);
        
        MoneyCalculatorControl moneyControl = new MoneyCalculatorControl(frame, exchangeRate);
        while (true) {
            moneyControl.execute();
        }
    }

    private void createCommands(ApplicationFrame frame, ExchangeRateLoader exchangeRate) {
        commandMap= new HashMap<>();
        commandMap.put("calculate", new CalculateCommand(
                frame.getMoneyDialog(), 
                frame.getCurrencyDialog(),
                frame.getMoneyViewer(),
                exchangeRate)
        );
        
        commandMap.put("exit", new Command() {

            @Override
            public void execute() {
                System.exit(0);
            }
        });
    }
    
    private DataBaseExchangeRateLoader createExchangeRateLoader() {
        return new DataBaseExchangeRateLoader();
    }

//    private static DialogInterface createDialog() {
//        return new ConsoleMoneyCalculator(new BufferedReader(new InputStreamReader(System.in)));
//        return new SwingMoneyCalculator();
//    }
    private CurrencySetLoader createCurrencySetLoader() {
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

    private ApplicationFrame createApplicationFrame() {
        return new SwingApplicationFrame(new ActionListenerFactory() {
            @Override
            public ActionListener createActionListener(final String action) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Command command = commandMap.get(action.toLowerCase());
                        if (command == null) return;
                        command.execute();
                    }
                };
            }
        });
    }

    private void numberTest() {
        MoneyAmount number1 = new MoneyAmount(2, 6);
        MoneyAmount number2 = new MoneyAmount(1, 3);
        MoneyAmount number3 = new MoneyAmount(5, 2);
        MoneyAmount number4 = new MoneyAmount(25, 100);
        MoneyAmount number5 = new MoneyAmount(number4);
        MoneyAmount number6 = new MoneyAmount(0.5);
        MoneyAmount number7 = new MoneyAmount(2.5);
        MoneyAmount number8 = MoneyAmount.valueOf("200.15");
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
