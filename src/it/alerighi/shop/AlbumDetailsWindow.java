package it.alerighi.shop;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Finestra che mostra i dettagli di un album
 *
 * @author Alessandro Righi
 */
public class AlbumDetailsWindow extends JDialog {

    public AlbumDetailsWindow(String title) {
    	setResizable(false);
        setTitle("Dettagli album " + title);
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(getParent());
    	JPanel panel = new JPanel();

        Album album = DatabaseConnection.getInstance().getAlbumWithTitle(title);
        getContentPane().setLayout(null);

        JLabel label = new JLabel("Titolo: " + album.getTitle());
        label.setBounds(167, 25, 227, 16);
        getContentPane().add(label);
        JLabel label_1 = new JLabel("Autore: " + album.getAuthor());
        label_1.setBounds(167, 53, 227, 16);
        getContentPane().add(label_1);
        JLabel label_2 = new JLabel("Genere: " + album.getGenre());
        label_2.setBounds(167, 81, 227, 16);
        getContentPane().add(label_2);
        JLabel label_3 = new JLabel("In vendita da: " + album.getDateSinceOnSale());
        label_3.setBounds(167, 109, 227, 16);
        getContentPane().add(label_3);
        JLabel label_4 = new JLabel("Prezzo: " + album.getPrice() + "€");
        label_4.setBounds(167, 137, 110, 18);
        getContentPane().add(label_4);
        panel.setBounds(25, 25, 130, 130);
        getContentPane().add(panel);

        
        JLabel elencoBrani = new JLabel("Elenco brani:");
        elencoBrani.setBounds(25, 350, 124, 16);
        getContentPane().add(elencoBrani);
        
        JLabel lblNewLabel = new JLabel("Musicisti partecipanti:");
        lblNewLabel.setBounds(25, 205, 369, 16);
        getContentPane().add(lblNewLabel);
        
        
        
        String[][] musicians = new String[album.getMusicians().size()][2];
        
        for (int i = 0; i < musicians.length; i++) {
        	musicians[i][0] = album.getMusicians().get(i);
        	musicians[i][1] = album.getInstruments().get(i);
        }
       
        JTable table = new JTable(new DefaultTableModel(
        		musicians,
        		new String[] {"Musicista", "Strumento suonato"}
        		));
        table.setEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane_1 = new JScrollPane(table);
        scrollPane_1.setBounds(25, 233, 350, 110);
        getContentPane().add(scrollPane_1);

        
        JList<Object> list = new JList<>();
        list.setListData(album.getSongs().toArray());

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(25, 378, 350, 178);
        getContentPane().add(scrollPane);
        
        JButton btnAcquista = new JButton("Aggiungi al carrello");
        btnAcquista.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnAcquista.setBounds(25, 167, 350, 29);
        getContentPane().add(btnAcquista);




        setVisible(true);
    }
}
