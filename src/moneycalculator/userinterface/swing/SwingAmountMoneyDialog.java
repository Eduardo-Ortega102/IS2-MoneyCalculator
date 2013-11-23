package moneycalculator.userinterface.swing;

import javax.swing.JTextField;
import moneycalculator.model.Number;

public class SwingAmountMoneyDialog extends JTextField {

    private Number amount;
    private static SwingAmountMoneyDialog instance;

    private SwingAmountMoneyDialog() {
        super(15);
    }

    public static SwingAmountMoneyDialog getInstance() {
        if (instance == null) {
            instance = new SwingAmountMoneyDialog();
        }
        return instance;
    }

    public void inicializeMoney() {
        try {
            amount = Number.valueOf(this.getText());
        } catch (NumberFormatException ex) {
        }
    }

    public Number getAmount() {
        return amount;
    }
}
