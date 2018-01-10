package it.alerighi.shop;

import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class CreateUserDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField cityField;
    private JTextField fiscalCodeField;
    private JTextField phoneField;
    private JTextField mobileField;
    private JPasswordField passwordConfirmField;

    public CreateUserDialog() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Registra nuovo utente");
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void onOK() {
        User user = null;

        if (userNameField.getText().length() <= 0)
            JOptionPane.showMessageDialog(this, "Il nome utente non può essere vuoto", "Errore", JOptionPane.ERROR_MESSAGE);
        else if (firstNameField.getText().length() <= 0)
            JOptionPane.showMessageDialog(this, "Il nome non può essere vuoto", "Errore", JOptionPane.ERROR_MESSAGE);
        else if (lastNameField.getText().length() <= 0)
            JOptionPane.showMessageDialog(this, "Il cognome non può essere vuoto", "Errore", JOptionPane.ERROR_MESSAGE);
        else if (passwordField.getPassword().length < 8)
            JOptionPane.showMessageDialog(this, "La password deve essere di almeno 8 caratteri", "Errore", JOptionPane.ERROR_MESSAGE);
        else if (cityField.getText().length() <= 0)
            JOptionPane.showMessageDialog(this, "Il campo città non può essere vuoto", "Errore", JOptionPane.ERROR_MESSAGE);
        else if (fiscalCodeField.getText().length() <= 0)
            JOptionPane.showMessageDialog(this, "Il campo codice fiscale non può essere vuoto", "Errore", JOptionPane.ERROR_MESSAGE);
        else if (phoneField.getText().length() <= 0)
            JOptionPane.showMessageDialog(this, "Il campo numero di telefono non può essere vuoto", "Errore", JOptionPane.ERROR_MESSAGE);
        else if (!Arrays.equals(passwordField.getPassword(), passwordConfirmField.getPassword()))
            JOptionPane.showMessageDialog(this, "Le password inserite non corrispondono", "Errore", JOptionPane.ERROR_MESSAGE);
        else
            user = new User(userNameField.getText(),
                    new String(passwordField.getPassword()),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    cityField.getText(),
                    fiscalCodeField.getText(),
                    phoneField.getText(),
                    mobileField.getText(),
                    false
            );

        if (user == null)
            return;

        if (!Database.getUsersDatabase().addUser(user))
            JOptionPane.showMessageDialog(this, "Nome utente già utilizzato", "Errore", JOptionPane.ERROR_MESSAGE);
        else
            dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
