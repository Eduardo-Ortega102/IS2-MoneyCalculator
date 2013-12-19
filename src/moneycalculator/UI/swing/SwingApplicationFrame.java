package moneycalculator.UI.swing;

import java.awt.*;
import javax.swing.*;
import moneycalculator.UI.ApplicationFrame;
import moneycalculator.UI.CurrencyDialog;
import moneycalculator.UI.MoneyDialog;
import moneycalculator.UI.MoneyViewer;

public class SwingApplicationFrame extends JFrame implements ApplicationFrame {

    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;
    private MoneyViewer moneyViewer;
    private ActionListenerFactory factory;

    public SwingApplicationFrame(ActionListenerFactory factory) throws HeadlessException {
        super("Money Calculator");
        this.factory = factory;
        this.setSize(600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.createComponents();
    }

    private void createComponents() {
        this.add(createMainPanel(), BorderLayout.CENTER);
        this.add(createToolBar(), BorderLayout.SOUTH);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(createMoneyDialog());
        panel.add(createCurrencyDialog());
        panel.add(createMoneyViewer());
        return panel;
    }

    private JPanel createToolBar() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(createButton("Calculate"));
        panel.add(createButton("Exit"));
        return panel;
    }

    private MoneyDialogPanel createMoneyDialog() {
        MoneyDialogPanel panel = new MoneyDialogPanel();
        this.moneyDialog = panel;
        return panel;
    }

    private CurrencyDialogPanel createCurrencyDialog() {
        CurrencyDialogPanel panel = new CurrencyDialogPanel();
        this.currencyDialog = panel;
        return panel;
    }

    private MoneyViewerPanel createMoneyViewer() {
        MoneyViewerPanel panel = new MoneyViewerPanel();
        this.moneyViewer = panel;
        return panel;
    }

    private JButton createButton(String action) {
        JButton button = new JButton(action);
        button.addActionListener(factory.createActionListener(action));
        return button;
    }

    @Override
    public MoneyDialog getMoneyDialog() {
        return this.moneyDialog;
    }

    @Override
    public MoneyViewer getMoneyViewer() {
        return this.moneyViewer;
    }

    @Override
    public CurrencyDialog getCurrencyDialog() {
        return this.currencyDialog;
    }

    @Override
    public void execute() {
        this.setVisible(true);
    }
}
