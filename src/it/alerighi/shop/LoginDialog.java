package it.alerighi.shop;

import javax.swing.*;
import java.awt.event.*;

public class LoginDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton buttonCreateUser;
    private JTextField userNameField;
    private JPasswordField passwordField;

    /**
     * Utente loggato
     */
    private User user = null;

    /**
     * Costruttore del login dialog
     */
    public LoginDialog() {
        setContentPane(contentPane);
        setTitle("Accedi al negozio");
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> dispose());
        buttonCreateUser.addActionListener(e -> new CreateUserDialog());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Method that gets executed on OK button click
     */
    private void onOK() {

        if (userNameField.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "Il nome utente non può essere vuoto", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (passwordField.getPassword().length <= 0) {
            JOptionPane.showMessageDialog(this, "La password non può essere vuota", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        user = Database.getUsersDatabase().authenticateUser(userNameField.getText(), new String(passwordField.getPassword()));
        if (user == null)
            JOptionPane.showMessageDialog(this, "Username o password errati", "Errore", JOptionPane.ERROR_MESSAGE);
        else
            dispose();
    }

    /**
     * Show login dialog
     *
     * @return user logged in
     */
    public User showDialog() {
        return user;
    }
}
