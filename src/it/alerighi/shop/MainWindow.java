package it.alerighi.shop;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Finestra principale dell'applicazione
 *
 * @author Alessandro Righi
 */
public class MainWindow extends JFrame implements Observer {

    /**
     * Titolo della finestra
     */
    public static final String TITLE = "Negozio CD";

    /**
     * Utente se loggato, null altrimenti
     */
    private User user = null;

    /**
     * Tabella dei cd
     */
    private JTable table;

    /**
     * Oggetto carrello
     */
    private Cart cart = Cart.getInstance();

    /**
     * Oggetto catalogo
     */
    private Catalog catalog = Database.getCatalogDatabase();

    /**
     * lista degli album
     */
    private List<Album> albums;

    /**
     * Bottone carrello
     */
    private JButton cartButton = new JButton();

    private CartWindow cartWindow = new CartWindow();


    /**
     * Costruttore della finestra
     */
    public MainWindow() {
        initializeUI();
        cart.registerObserver(this);
        update();
    }

    /**
     * Setta gli album secondo la query specificata
     *
     * @param mode modalità di query
     * @param parameter parametro query
     */
    private void getAlbums(String mode, String parameter) {

        DefaultTableModel model = new DefaultTableModel(
                null,
                new String[] {"Titolo", "Autore", "Genere"})
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        if (mode == null)
        	albums = catalog.getAlbums();
        else if (mode.equals("titolo"))
        	albums = catalog.getAlbumsByTitle(parameter);
        else if (mode.equals("genere"))
        	albums = catalog.getAlbumsByGenre(parameter);
        else if (mode.equals("autore"))
        	albums = catalog.getAlbumsByAuthor(parameter);
        else if (mode.equals("musicista"))
        	albums = catalog.getAlbumsByMusician(parameter);
        else if (mode.equals("prezzo minore di"))
        	albums = catalog.getAlbumsByPrice(Integer.parseInt(parameter));
        
        
        for (Album album: albums) {
        	model.addRow(new String[] {album.getTitle(), album.getAuthor(), album.getGenre()});
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
        JComboBox comboBox = new JComboBox(new String[] {"titolo", "genere", "autore", "musicista", "prezzo minore di"});
        toolBar.add(comboBox);
        JTextField tf = new JTextField();
        toolBar.add(tf);
        JButton button_1 = new JButton("Cerca");
        button_1.addActionListener(e -> getAlbums((String) comboBox.getSelectedItem(), tf.getText()));
        toolBar.add(button_1);

        cartButton.addActionListener(e -> cartWindow.setVisible(true));
        toolBar.add(cartButton);
        JButton buttonLogin = new JButton(user == null ? "Login" : "Logout");
        buttonLogin.addActionListener(e -> {
        	if (user != null)
        		user = null;
        	else 
        		user = new LoginDialog().showDialog();
        	buttonLogin.setText(user == null ? "Login" : "Logout (" + user.getUsername() + ")");
        });
        toolBar.add(buttonLogin);
        
        getContentPane().add(toolBar, BorderLayout.PAGE_START);


        table = new JTable();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = table.rowAtPoint(e.getPoint());
                    new AlbumDetailDialog(albums.get(row));
                }
            }
        });

        getAlbums(null, null);
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Aggiorna il conto oggetti nel carrello quando chiamato dall'osservato
     */
    public void update() {
    	cartButton.setText("Carrello (" + "" + cart.numberOfItems() + ")");
    }

}
