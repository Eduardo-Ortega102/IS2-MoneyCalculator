package moneycalculator.UI.swing;

import javax.swing.*;
import moneycalculator.UI.MoneyViewer;
import moneycalculator.model.Money;

public class MoneyViewerPanel extends JPanel implements MoneyViewer {

    private JTextField area;

    public MoneyViewerPanel() {
        super();
        this.createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        area = createResultField();
        this.add(area);
    }

    private JTextField createResultField() {
        return new JTextField(10);
    }

    @Override
    public void showMoney(Money money) {
        area.setText(money.getAmount() + " " + money.getCurrency());
    }
}
