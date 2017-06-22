package it.alerighi.shop;

import static it.alerighi.shop.Util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che gestisce l'accesso al database.
 * Paradigma usato: singleton
 * 
 * @author Alessandro Righi
 */
public final class DatabaseConnection {


    private static DatabaseConnection instance = null;

    private Connection connection = null;
    
    private final String DB_HOST = "localhost";
    private final String DB_USER = "negozio";
    private final String DB_PASS = "negozio";
    private final String DB_NAME = "NegozioCD";

    /**
     * Costruttore della classe
     */
    private DatabaseConnection() {
        connect();
    }

    public Connection getConnection()  {
        if (connection == null)
            connect();
        return connection;
    }

    /**
     * Ritorna l'istanza della classe
     *
     * @return istanza della classe
     */
    public static DatabaseConnection getInstance() {
        if (instance == null)
            instance = new DatabaseConnection();
        return instance;
    }

    /**
     * Stabilisce una connessione al database
     */
    private void connect() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + "/" + DB_NAME + "?user=" + DB_USER + "&password=" + DB_PASS);
        } catch (SQLException e) {
            die("Errore connessione al database");
        }

        info("Connessione al database stabilita");
    }

    /**
     * Funzione che autentica un utente
     *
     * @param username nome utente
     * @param password password
     * @return ritorna true nel caso l'utente sia autenticato, false altrimenti
     */
    public boolean authenticateUser(String username, String password) {
        String query = "SELECT password FROM utenti WHERE username = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            if (!result.next())
                return false;
            String pass = result.getString(1);
            return pass.equals(password);
        } catch (SQLException e) {
            die("Errore query ");
        }

        return false;
    }

    /**
     * Aggiunge un nuovo utente al sistema
     *
     * @param username nome utente
     * @param password password utente
     * @param fistName nome
     * @param lastName cognome
     * @param fiscalCode codice fiscale
     * @param residence residenza
     * @param phone numero di telefono
     * @param mobile numero di cellulare
     * @return true se l'aggiunta dell'utente è andata a buon fine, false se l'utente è già stato utilizzato
     */
    public boolean addUser(String username, String password, String fistName, String lastName, String fiscalCode,
                        String residence, String phone, String mobile) {
        String query = "SELECT * FROM utenti WHERE username = ?";
        String query2 = "INSERT INTO utenti (codice_fiscale, username, password, nome, cognome, residenza, telefono, cellulare) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            if (result.next()) // esiste già un utente con il nome selezionato
                return false;

            statement = connection.prepareStatement(query2);
            statement.setString(1, fiscalCode);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, fistName);
            statement.setString(5, lastName);
            statement.setString(6, residence);
            statement.setString(7, phone);
            statement.setString(8, mobile);
            statement.executeUpdate();
        } catch (SQLException e) {
            die("Errore query");
        }

        return true;
    }

    /**
     * Elimina un utente dal sistema
     *
     * @param username nome dell'utente da eliminare
     * @return true se l'utente è stato eliminato, false se l'utente non esisteva
     */
    public boolean deleteUser(String username) {
        String query = "DELETE FROM utenti WHERE username = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            die("Errore query");
        }
        return false;
    }

    

   
}
