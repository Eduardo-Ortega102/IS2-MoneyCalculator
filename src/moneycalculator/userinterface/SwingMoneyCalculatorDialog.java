package moneycalculator.userinterface;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
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
    private JTextArea resultArea;

    public SwingMoneyCalculatorDialog() throws HeadlessException {
        int width = 550;
        int height = 500;
        this.setTitle("MoneyCalculator");
        this.setSize(width, height);
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.setLocation(
                (int) ((tk.getScreenSize().getWidth() - width) / 2),
                (int) ((tk.getScreenSize().getHeight() - height) / 2));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 1));
        this.add(createInputPanel(), 0);
        this.add(createOutputPanel(), 1);
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

//    @Override
//    public void show() {
//        JFrame frame = new JFrame();
//        JOptionPane.showMessageDialog(frame, "Not suported yet.");
//    }
    @Override
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public Money getMoney() {
        return money;
    }

    private JPanel createButtonPanel() {
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pane.setBackground(Color.BLUE);
        JButton button = new JButton("Change");
        button.setBounds(new Rectangle(30, 20));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                execute = false;
            }
        });
        pane.add(button);
        return pane;
    }

    private void inicialiceAttributes() {
        amount.inicializeMoney();
        if (amount.getAmount() != null) {
            money = new Money(amount.getAmount(), currency1.getCurrency());
            currency = currency2.getCurrency();
        }
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.red);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        amount = SwingAmountMoneyDialog.getInstance();
        currency1 = SwingCurrencyDialog.getInstance1();
        currency2 = SwingCurrencyDialog.getInstance2();
        panel.add(amount);
        panel.add(currency1);
        panel.add(currency2);
        return panel;
    }

    private JPanel createOutputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        JPanel pane = new JPanel();
        pane.setBackground(Color.GREEN);
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));
        pane.add(new Label("Result: "));
        resultArea = new JTextArea();
        pane.add(resultArea);
        resultArea.setText("LOOOOOOOOOOOOOOOOOOOOOL");
        panel.add(pane, 0);
        panel.add(createButtonPanel(), 1);
        return panel;
    }
}
