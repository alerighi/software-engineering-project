package it.alerighi.shop;

import javax.swing.*;
import java.awt.BorderLayout;

public class BuyWindow extends JFrame {

	public BuyWindow() {
		setTitle("Acquista prodotti");
		setSize(531, 317);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JTextField textField;
		JTextField textField_1;
		JTextField textField_2;
		JTextField textField_3;
		JTextField textField_4;
		JTextField textField_5;
		JTextField textField_6;
		JTextField textField_7;
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Introduzione", null, panel, null);
		panel.setLayout(null);
		
		JButton btnAnnulla_1 = new JButton("Annulla");
		btnAnnulla_1.addActionListener(e -> dispose());
		btnAnnulla_1.setBounds(366, 226, 67, 23);
		panel.add(btnAnnulla_1);
		
		JButton btnAvanti_1 = new JButton("Avanti");
		btnAvanti_1.addActionListener(e -> {tabbedPane.setSelectedIndex(1); tabbedPane.setEnabledAt(1,  true); tabbedPane.setEnabledAt(0, false);});
		btnAvanti_1.setBounds(438, 226, 72, 23);
		panel.add(btnAvanti_1);
		
		JLabel lblSeguireLaProcedura = new JLabel("Seguire la procedura guidata per acquistare i prodotti contenuti nel carrello");
		lblSeguireLaProcedura.setBounds(10, 11, 500, 23);
		panel.add(lblSeguireLaProcedura);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Spedizione", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblInserireInformazioniDi = new JLabel("Inserire informazioni di spedizione");
		lblInserireInformazioniDi.setBounds(10, 11, 161, 14);
		panel_1.add(lblInserireInformazioniDi);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo");
		lblIndirizzo.setBounds(10, 43, 40, 14);
		panel_1.add(lblIndirizzo);
		
		textField = new JTextField();
		textField.setBounds(55, 40, 459, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblCitt = new JLabel("Città ");
		lblCitt.setBounds(10, 68, 26, 14);
		panel_1.add(lblCitt);
		
		textField_1 = new JTextField();
		textField_1.setBounds(55, 65, 333, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(394, 68, 43, 14);
		panel_1.add(lblProvincia);
		
		textField_3 = new JTextField();
		textField_3.setBounds(447, 65, 63, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCap = new JLabel("CAP");
		lblCap.setBounds(10, 93, 20, 14);
		panel_1.add(lblCap);
		
		textField_2 = new JTextField();
		textField_2.setBounds(55, 90, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblModalitDiSpedizione = new JLabel("Modalità di spedizione");
		lblModalitDiSpedizione.setBounds(10, 129, 118, 14);
		panel_1.add(lblModalitDiSpedizione);
		
		JComboBox comboBox = new JComboBox(new String[] {"Corriere Bartolini", "Corriere SDA", "Poste Italiane"});
		comboBox.setBounds(124, 126, 266, 20);
		panel_1.add(comboBox);
		
		JLabel lblCostoDiSpedizione = new JLabel("Costo di spedizione: X euro");
		lblCostoDiSpedizione.setBounds(10, 154, 130, 14);
		panel_1.add(lblCostoDiSpedizione);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(e -> dispose());
		btnAnnulla.setBounds(307, 226, 67, 23);
		panel_1.add(btnAnnulla);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(e -> {tabbedPane.setSelectedIndex(0); tabbedPane.setEnabledAt(0,  true); tabbedPane.setEnabledAt(1, false);});
		btnIndietro.setBounds(377, 226, 71, 23);
		panel_1.add(btnIndietro);
		
		JButton btnAvanti = new JButton("Avanti");
		btnAvanti.addActionListener(e -> {tabbedPane.setSelectedIndex(2); tabbedPane.setEnabledAt(2,  true); tabbedPane.setEnabledAt(1, false);});
		btnAvanti.setBounds(451, 226, 63, 23);
		panel_1.add(btnAvanti);
		
		JLabel lblTotaleYEuro = new JLabel("Totale: Y euro");
		lblTotaleYEuro.setBounds(10, 179, 137, 14);
		panel_1.add(lblTotaleYEuro);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Pagamento", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblInserireLeInformazioni = new JLabel("Inserire le informazioni per il pagamento");
		lblInserireLeInformazioni.setBounds(15, 7, 191, 14);
		panel_3.add(lblInserireLeInformazioni);
		
		JLabel lblModalitDiPagamento = new JLabel("Modalità di pagamento");
		lblModalitDiPagamento.setBounds(15, 44, 108, 14);
		panel_3.add(lblModalitDiPagamento);
		
		JComboBox comboBox_1 = new JComboBox(new String[] {"Carta di credito", "Bonifico", "PayPal"} );
		comboBox_1.setBounds(133, 41, 167, 20);
		panel_3.add(comboBox_1);
		
		JLabel lblNumeroCartaDi = new JLabel("Numero carta ");
		lblNumeroCartaDi.setBounds(15, 94, 108, 14);
		panel_3.add(lblNumeroCartaDi);
		
		textField_4 = new JTextField();
		textField_4.setBounds(133, 91, 167, 20);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCodiceDiSicurezza = new JLabel("PIN");
		lblCodiceDiSicurezza.setBounds(310, 94, 46, 14);
		panel_3.add(lblCodiceDiSicurezza);
		
		textField_7 = new JTextField();
		textField_7.setBounds(375, 91, 71, 20);
		panel_3.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblIntestatario = new JLabel("Intestatario carta");
		lblIntestatario.setBounds(15, 119, 108, 14);
		panel_3.add(lblIntestatario);
		
		textField_5 = new JTextField();
		textField_5.setBounds(133, 116, 167, 20);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblScadenza = new JLabel("Scadenza");
		lblScadenza.setBounds(310, 119, 46, 14);
		panel_3.add(lblScadenza);
		
		textField_6 = new JTextField();
		textField_6.setBounds(375, 116, 71, 20);
		panel_3.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnAnnulla_3 = new JButton("Annulla");
		btnAnnulla_3.addActionListener(e -> dispose());
		btnAnnulla_3.setBounds(304, 226, 67, 23);
		panel_3.add(btnAnnulla_3);
		
		JButton btnIndietro_2 = new JButton("Indietro");
		btnIndietro_2.addActionListener(e -> {tabbedPane.setSelectedIndex(1); tabbedPane.setEnabledAt(1,  true); tabbedPane.setEnabledAt(2, false);});
		btnIndietro_2.setBounds(375, 226, 71, 23);
		panel_3.add(btnIndietro_2);
		
		JButton btnAvanti_3 = new JButton("Avanti");
		btnAvanti_3.addActionListener(e -> {tabbedPane.setSelectedIndex(3); tabbedPane.setEnabledAt(3,  true); tabbedPane.setEnabledAt(2, false);});
		btnAvanti_3.setBounds(447, 226, 63, 23);
		panel_3.add(btnAvanti_3);
		
		JLabel lblTipoCarta = new JLabel("Tipo carta");
		lblTipoCarta.setBounds(15, 69, 113, 14);
		panel_3.add(lblTipoCarta);
		
		JComboBox comboBox_2 = new JComboBox(new String[] {"Mastarcard", "Visa", "Postepay"});
		comboBox_2.setBounds(133, 66, 167, 20);
		panel_3.add(comboBox_2);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Fine", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblLordineIn = new JLabel("L'ordine è in fase di lavorazone. ");
		lblLordineIn.setBounds(24, 29, 404, 14);
		panel_4.add(lblLordineIn);
		
		JLabel lblRiceverUnMessaggio = new JLabel("Riceverà un messaggio quando l'ordine sarà spedito");
		lblRiceverUnMessaggio.setBounds(24, 54, 404, 14);
		panel_4.add(lblRiceverUnMessaggio);
		
		JButton btnFine = new JButton("Fine");
		btnFine.addActionListener(e -> dispose());
		btnFine.setBounds(457, 226, 53, 23);
		panel_4.add(btnFine);
		// TODO Auto-generated constructor stub
		
		tabbedPane.setEnabledAt(1, false);
		tabbedPane.setEnabledAt(2, false);
		tabbedPane.setEnabledAt(3, false);

		
		setVisible(true);
	}
}
