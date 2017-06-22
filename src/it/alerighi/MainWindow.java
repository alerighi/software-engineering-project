package it.alerighi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static it.alerighi.Util.die;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Finestra principale dell'applicazione
 *
 * @author Alessandro Righi
 */
public class MainWindow extends JFrame {

    public static final String TITLE = "Negozio CD";

    private String user = null;
    private JTable table;

    /**
     * Costruttore della finestra
     */
    public MainWindow() {
        initializeUI();
    }

    private void getAlbums() {

        Connection conn = DatabaseConnection.getInstance().getConnection();
        DefaultTableModel model = new DefaultTableModel(
                null,
                new String[] {"Titolo", "Autore", "Genere"})
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT titolo, titolare, genere FROM cd");
            while (result.next()) {
                Object[] data = new Object[] {
                        result.getString("titolo"),
                        result.getString("titolare"),
                        result.getString("genere")
                };

                model.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            die("Errore query");
        }

        table.setModel(model);

    }

    /**
     * Inizializzazione dei componenti dell'interfaccia grafia
     */
    private void initializeUI() {
        setTitle(TITLE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());


        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.add(new JLabel("Ricerca per"));
        toolBar.add(new JComboBox(new String[] {"titolo", "genere", "autore", "prezzo minore di"} ));
        toolBar.add(new JTextField());
        toolBar.add(new JButton("Cerca"));

        toolBar.add(new JButton("Visualizza carrello"));
        JButton buttonLogin = new JButton(user == null ? "Login" : "Logout");
        buttonLogin.addActionListener(e -> {
        	if (user != null)
        		user = null;
        	else 
        		user = new LoginDialog().showDialog();
        });
        toolBar.add(buttonLogin);
        
        getContentPane().add(toolBar, BorderLayout.PAGE_START);


        table = new JTable();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = table.rowAtPoint(e.getPoint());
                    String titolo = (String) table.getModel().getValueAt(row, 0);
                    new AlbumDetailsWindow(titolo);
                }
            }
        });

        getAlbums();
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

}
