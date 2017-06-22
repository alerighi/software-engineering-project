package it.alerighi.shop;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Classe che mostra una finestra di dialogo per il login.
 * 
 * @author Alessandro Righi
 */
public class LoginDialog extends JDialog {
	private String username = null;
	
	/**
	 * Mostra il dialogo per il login
	 * 
	 * @return l'username dell'utente nel caso il login abbia successo, null altrimenti
	 */
	public String showDialog() {
		setVisible(true);
		return username;
	}
	
	/**
	 * Costruttore del dialogo per il login
	 */
	public LoginDialog() {
		setResizable(false);
		setSize(300, 160);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(getParent());
		setTitle("Accedi al negozio");
		getContentPane().setLayout(null);
		
		JLabel lblNomeUtente = new JLabel("Nome utente");
		lblNomeUtente.setBounds(20, 25, 90, 16);
		getContentPane().add(lblNomeUtente);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(20, 53, 90, 16);
		getContentPane().add(lblPassword);
		
		JTextField textField;
		JTextField textField_1;
		
		textField = new JTextField();
		textField.setBounds(122, 20, 158, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 48, 158, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel messageLabel = new JLabel("");
		messageLabel.setBounds(20, 81, 260, 16);
		getContentPane().add(messageLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(e -> {
			String username = textField.getText();
			String password = textField_1.getText();
			if (DatabaseConnection.getInstance().authenticateUser(username, password)) {
				this.username = username;
				this.dispose();
		  	} else {
				messageLabel.setText("Username o password errati!");				
		  	}
		});
		btnLogin.setBounds(181, 103, 99, 29);
		getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(e -> {
			this.dispose();
		});
		btnCancel.setBounds(80, 103, 99, 29);
		getContentPane().add(btnCancel);
		
	}
	
	
}
