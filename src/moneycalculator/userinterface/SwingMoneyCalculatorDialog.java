package moneycalculator.userinterface;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.userinterface.swing.SwingCurrencyDialog;
import moneycalculator.userinterface.swing.SwingAmountMoneyDialog;

public class SwingMoneyCalculatorDialog extends JFrame implements MoneyCalculatorDialogInterface {

    private Currency currency;
    private Money money;
    private SwingAmountMoneyDialog amount;
    private SwingCurrencyDialog currency1;
    private SwingCurrencyDialog currency2;
    private boolean execute;

    public SwingMoneyCalculatorDialog() throws HeadlessException {
        this.setTitle("MoneyCalculator");
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.setLocation(
                (int) ((tk.getScreenSize().getWidth() - 500) / 2),
                (int) ((tk.getScreenSize().getHeight() - 500) / 2));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        amount = SwingAmountMoneyDialog.getInstance();
        currency1 = SwingCurrencyDialog.getInstance1();
        currency2 = SwingCurrencyDialog.getInstance2();
        this.add(amount);
        this.add(currency1);
        this.add(currency2);
        this.add(createButton());
        this.pack();
    }

    @Override
    public void execute() {
        this.setVisible(true);
        execute = true;
        while (execute) {
            inicialiceAttributes();
        }
    }

    @Override
    public void show() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Not suported yet.");
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public Money getMoney() {
        return money;
    }

    private JButton createButton() {
        JButton button = new JButton("Change");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                execute = false;
            }
        });
        return button;
    }

    private void inicialiceAttributes() {
        amount.inicializeMoney();
        if (amount.getAmount() != null) {
            money = new Money(amount.getAmount(), currency1.getCurrency());
            currency = currency2.getCurrency();
        }
    }
}
