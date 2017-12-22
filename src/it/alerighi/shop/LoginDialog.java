package it.alerighi.shop;

import javax.swing.*;
import java.awt.event.*;

public class LoginDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton buttonCreateUser;

    /**
     * Utente loggato
     */
    private User user = null;

    public LoginDialog() {
        setContentPane(contentPane);
        setTitle("Accedi al negozio");
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setLocationRelativeTo(null);
        pack();
        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        buttonCreateUser.addActionListener(e -> new CreateUserDialog().setVisible(true));

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {

        if (userNameField.getText().length() <= 0)
            JOptionPane.showMessageDialog(this, "Il nome utente non può essere vuoto", "Errore", JOptionPane.ERROR_MESSAGE);
        if (passwordField.getPassword().length <= 0)
            JOptionPane.showMessageDialog(this, "La password non può essere vuota", "Errore", JOptionPane.ERROR_MESSAGE);
        else
            user = new UsersDatabase().authenticateUser(userNameField.getText(), new String(passwordField.getPassword()));

        if (user == null)
            JOptionPane.showMessageDialog(this, "Username o password errati", "Errore", JOptionPane.ERROR_MESSAGE);
        else
            dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public User showDialog() {
        setVisible(true);
        return user;
    }
}
