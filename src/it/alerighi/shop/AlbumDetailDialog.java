package it.alerighi.shop;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Classe che mostra una finestra di dettagli di un album
 */
public class AlbumDetailDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel labelAuthor;
    private JLabel labelGenre;
    private JLabel labelSaleSince;
    private JLabel labelPrice;
    private JList songList;
    private JTable musiciansTable;
    private JButton buttonAddToCart;
    private JPanel imagePanel;
    private Album album;

    /**
     * Costruisce e mostra la finestra di dettagli su un album
     *
     * @param album album del quale mostrare i dettagli
     */
    public AlbumDetailDialog(Album album) {
        this.album = album;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Dettagli album " + album.getTitle());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        labelAuthor.setText("Autore: " + album.getAuthor());
        labelGenre.setText("Genere: " + album.getGenre());
        labelSaleSince.setText("In vendita da: " + album.getDateSinceOnSale());
        labelPrice.setText("Prezzo: " + String.format("%4.2f", album.getPrice()) + "€");
        songList.setListData(album.getSongs());
        buttonAddToCart.addActionListener(e -> Cart.getInstance().add(album));

        String[][] musicians = new String[album.getMusicians().length][2];

        for (int i = 0; i < musicians.length; i++) {
            musicians[i][0] = album.getMusicians()[i].toString();
            musicians[i][1] = album.getInstruments()[i];
        }

        musiciansTable.setModel(new DefaultTableModel(
                musicians,
                new String[] {"Musicista", "Strumento suonato"}
        ));
        musiciansTable.setEnabled(false);
        musiciansTable.getTableHeader().setReorderingAllowed(false);
        musiciansTable.setFillsViewportHeight(true);


        buttonOK.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createUIComponents() {
        imagePanel = new ImagePanel("/Users/ale/git/software-engineering-project/img/" + album.getCover());
    }

    /**
     * Inner class che estende un JPanel per mostrare un immagine
     */
    public final class ImagePanel extends JPanel{

        private BufferedImage image;

        /**
         * Costruisce un nuovo pannello mostra immagine
         *
         * @param filename path dell'immagine da mostrare
         */
        public ImagePanel(String filename) {
            try {
                image = ImageIO.read(new File(filename));
            } catch (IOException ex) {
                System.out.println("Cannot open " + filename);
            }
        }

        /**
         * Disegna il componente e mostra l'immagine
         *
         * @param g area grafica
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (image != null)
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}