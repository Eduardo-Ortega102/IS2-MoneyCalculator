package moneycalculator.UI.swing;

import java.awt.FlowLayout;
import javax.swing.*;
import moneycalculator.UI.MoneyViewer;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.model.MoneyAmount;

public class MoneyViewerPanel extends JPanel implements MoneyViewer {

    private JTextField area;
    private JLabel fromCurrencyLabel;
    private JLabel toCurrencyLabel;

    public MoneyViewerPanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        this.createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        area = createResultField();
        fromCurrencyLabel = new JLabel("");
        toCurrencyLabel = new JLabel("");
        this.add(fromCurrencyLabel);
        this.add(area);
        this.add(toCurrencyLabel);
    }

    private JTextField createResultField() {
        return new JTextField(10);
    }

    @Override
    public void showMoney(MoneyAmount sourceAmount, Currency fromCurrency, Money newMoney) {
        fromCurrencyLabel.setText(sourceAmount.toString() + fromCurrency + " son ");
        area.setText(newMoney.getAmount().toString());
        fromCurrencyLabel.setText(newMoney.getCurrency().toString());
    }




}
