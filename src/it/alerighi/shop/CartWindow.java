package it.alerighi.shop;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CartWindow extends JFrame implements Observer {
    private JButton buttonClose;
    private JButton buyButton;
    private JButton removeItem;
    private JTable itemTable;
    private JPanel contentPane;
    private Cart cart = Cart.getInstance();

    public CartWindow() {
        setTitle("Carrello");
        setLocationRelativeTo(null);
        buttonClose.addActionListener(e -> dispose());
        buyButton.addActionListener(e -> new BuyWindow().setVisible(true));
        removeItem.addActionListener(e -> remove());
        cart.registerObserver(this);

        update();
        itemTable.setFillsViewportHeight(true);
        itemTable.getTableHeader().setReorderingAllowed(false);

        setContentPane(contentPane);

        pack();
        setVisible(true);
    }

    @Override
    public void update() {
        DefaultTableModel model = new DefaultTableModel(
                null,
                new String[] {"Titolo", "Quantità"})
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        cart.getMap().forEach((key, value) -> model.addRow(new Object[] {key, value}));
        itemTable.setModel(model);
    }

    private void remove() {
        int row = itemTable.getSelectedRow();
        if (row < 0)
            return;
        Object a = itemTable.getModel().getValueAt(row, 0);
        cart.remove((Album) a);
    }
}
