package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.UI.ApplicationFrame;
import moneycalculator.UI.swing.ActionListenerFactory;
import moneycalculator.UI.swing.SwingApplicationFrame;
import moneycalculator.control.CalculateCommand;
import moneycalculator.control.Command;
import moneycalculator.persistence.CurrencySetLoader;
import moneycalculator.persistence.DataBaseCurrencySetLoader;
import moneycalculator.persistence.DataBaseExchangeRateLoader;
import moneycalculator.persistence.ExchangeRateLoader;

public class Application {

    private HashMap<String, Command> commandMap;

    public static void main(String[] args) throws IOException {
        new Application().execute();
    }

    private void execute() {
        try {
            CurrencySetLoader currencySetLoader = createCurrencySetLoader();
            currencySetLoader.load();
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        ApplicationFrame frame = createApplicationFrame();
        ExchangeRateLoader exchangeRate = createExchangeRateLoader();
        this.createCommands(frame, exchangeRate);
        frame.execute();

    }

    private void createCommands(ApplicationFrame frame, ExchangeRateLoader exchangeRateLoader) {
        commandMap = new HashMap<>();
        commandMap.put("calculate", new CalculateCommand(
                frame.getMoneyDialog(),
                frame.getCurrencyDialog(),
                frame.getMoneyViewer(),
                exchangeRateLoader));

        commandMap.put("exit", new Command() {
            @Override
            public void execute() {
                System.exit(0);
            }
        });
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

    private DataBaseExchangeRateLoader createExchangeRateLoader() {
        Connection connection;
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String user = "system";
            String passwd = "orcl";
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            connection = DriverManager.getConnection(url, user, passwd);
            return new DataBaseExchangeRateLoader(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private CurrencySetLoader createCurrencySetLoader() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String user = "system";
            String passwd = "orcl";
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection connection = DriverManager.getConnection(url, user, passwd);
            DataBaseCurrencySetLoader.createInstance(connection);
            return DataBaseCurrencySetLoader.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
