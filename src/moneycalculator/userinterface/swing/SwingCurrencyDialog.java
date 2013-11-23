package moneycalculator.userinterface.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class SwingCurrencyDialog extends JComboBox {

    private Currency currency;
    private static SwingCurrencyDialog instance1;
    private static SwingCurrencyDialog instance2;

    private SwingCurrencyDialog() {
        this.addItem(null);
        for (Currency item : CurrencySet.getInstance()) {
            this.addItem(item);
        }
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializeCurrency();
            }
        });
    }

    private void inicializeCurrency() {
        currency = (Currency) this.getSelectedItem();
    }

    public Currency getCurrency() {
        return currency;
    }

    public static SwingCurrencyDialog getInstance1() {
        if (instance1 == null) {
            instance1 = new SwingCurrencyDialog();
        }
        return instance1;
    }

    public static SwingCurrencyDialog getInstance2() {
        if (instance2 == null) {
            instance2 = new SwingCurrencyDialog();
        }
        return instance2;
    }
}
