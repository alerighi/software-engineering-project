package it.alerighi.shop;


import javax.swing.*;

/**
 * Classe main dell'applicazione
 *
 * @author Alessandro Righi
 */
public class Main {

    /**
     * Entry point del programma
     *
     * @param args argomenti del programma
     */
    public static void main(String[] args) {

        // imposto menù globale macOS
        System.setProperty("apple.awt.application.name", MainWindow.TITLE);
        System.setProperty("apple.laf.useScreenMenuBar", "true");

        // imposto stile nativo UI di sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // creo la finestra principale
        new MainWindow();
    }
}
