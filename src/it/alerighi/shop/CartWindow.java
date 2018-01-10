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
        buttonClose.addActionListener(e -> setVisible(false));
        //buyButton.addActionListener(e -> TODO: implementare );
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        removeItem.addActionListener(e -> remove());
        cart.registerObserver(this);

        update();
        itemTable.setFillsViewportHeight(true);
        itemTable.getTableHeader().setReorderingAllowed(false);

        setContentPane(contentPane);

        pack();
        setLocationRelativeTo(null);
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

    @Override
    public void dispose() {
        super.dispose();
        cart.deleteObserver(this);
    }
}
