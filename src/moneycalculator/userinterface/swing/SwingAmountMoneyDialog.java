package moneycalculator.userinterface.swing;

import javax.swing.JTextField;
import moneycalculator.model.MoneyAmount;

public class SwingAmountMoneyDialog extends JTextField {

    private MoneyAmount amount;
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
            amount = MoneyAmount.valueOf(this.getText());
        } catch (NumberFormatException ex) {
        }
    }

    public MoneyAmount getAmount() {
        return amount;
    }
}
