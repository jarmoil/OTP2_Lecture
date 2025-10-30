// java
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ShoppingCartUI {
    private final JFrame frame = new JFrame("Simple Shopping Cart");
    private final JComboBox<String> localeCombo;
    private final JTextField priceField = new JTextField(8);
    private final JTextField qtyField = new JTextField(4);
    private final DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Item", "Price", "Qty", "Line Total"}, 0) {
        public boolean isCellEditable(int row, int column) { return false; }
    };
    private final JTable table = new JTable(tableModel);
    private final JLabel totalLabel = new JLabel();
    private final List<Item> items = new ArrayList<>();
    private Locale currentLocale = Locale.US;
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(currentLocale);
    private NumberFormat numberFormat = NumberFormat.getNumberInstance(currentLocale);
    private int itemCounter = 1;

    public ShoppingCartUI() {
        localeCombo = new JComboBox<>(new String[]{"English (US)", "Finnish", "Japanese", "Swedish"});
        localeCombo.setSelectedIndex(0);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("Locale:"));
        top.add(localeCombo);
        top.add(new JLabel("Price:"));
        top.add(priceField);
        top.add(new JLabel("Qty:"));
        top.add(qtyField);

        JButton addBtn = new JButton("Add Item");
        top.add(addBtn);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel status = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        status.add(new JLabel("Grand total: "));
        status.add(totalLabel);
        bottom.add(status, BorderLayout.SOUTH);

        frame.setLayout(new BorderLayout());
        frame.add(top, BorderLayout.NORTH);
        frame.add(bottom, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        addBtn.addActionListener(e -> addItem());
        localeCombo.addActionListener(e -> switchLocale(localeCombo.getSelectedIndex()));
        refreshFormats();
        refreshTable();
    }

    private void switchLocale(int index) {
        switch (index) {
            case 1: currentLocale = new Locale("fi", "FI"); break;
            case 2: currentLocale = new Locale("ja", "JP"); break;
            case 3: currentLocale = new Locale("sv", "SE"); break;
            default: currentLocale = new Locale("en", "US"); break;
        }
        refreshFormats();
        refreshTable();
    }

    private void refreshFormats() {
        currencyFormat = NumberFormat.getCurrencyInstance(currentLocale);
        numberFormat = NumberFormat.getNumberInstance(currentLocale);
        numberFormat.setGroupingUsed(false);
        totalLabel.setText(currencyFormat.format(calculateGrandTotal()));
    }

    private void addItem() {
        try {
            String pText = priceField.getText().trim();
            String qText = qtyField.getText().trim();
            if (pText.isEmpty() || qText.isEmpty()) throw new ParseException("empty", 0);
            Number pNum = numberFormat.parse(pText);
            Number qNum = numberFormat.parse(qText);
            double price = pNum.doubleValue();
            int qty = qNum.intValue();
            if (qty <= 0) throw new IllegalArgumentException("qty");
            items.add(new Item("Item " + itemCounter++, price, qty));
            priceField.setText("");
            qtyField.setText("");
            refreshTable();
        } catch (ParseException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, "Enter valid numbers for price and quantity for current locale.", "Input error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double calculateGrandTotal() {
        return items.stream().mapToDouble(it -> it.price * it.qty).sum();
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Item it : items) {
            String priceStr = currencyFormat.format(it.price);
            String lineStr = currencyFormat.format(it.price * it.qty);
            tableModel.addRow(new Object[]{it.name, priceStr, it.qty, lineStr});
        }
        totalLabel.setText(currencyFormat.format(calculateGrandTotal()));
    }

    private static class Item {
        final String name;
        final double price;
        final int qty;
        Item(String name, double price, int qty) { this.name = name; this.price = price; this.qty = qty; }
    }

    public void show() {
        frame.setVisible(true);
    }
}
