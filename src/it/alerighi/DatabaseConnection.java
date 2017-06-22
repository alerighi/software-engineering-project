package it.alerighi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static it.alerighi.Util.*;

/**
 * Classe che gestisce l'accesso al database.
 * Paradigma usato: singleton
 *
 * @author Alessandro Righi
 */
public final class DatabaseConnection {


    private static DatabaseConnection instance = null;

    private Connection connection = null;

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
            connection = DriverManager.getConnection("jdbc:mysql://localhost/NegozioCD?user=negozio&password=negozio");
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

    /**
     * Ritorna la lista degli album presenti nel database
     *
     * @return lista di album nel database
     */
    public List<Album> getAlbums() {
        List<Album> albums = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM cd");
            while (result.next()) {
                albums.add(getAlbumDetails(result));
            }

        } catch (SQLException e) {
            die("Errore query");
        }

        return albums;
    }

    public Album getAlbumWithTitle(String title) {
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cd WHERE titolo = ?");
            st.setString(1, title);
            ResultSet res = (st.executeQuery());
            if (res.next())
                return getAlbumDetails(res);
            else
                return null;
        } catch (SQLException e) {
            die("Errore query");
        }
        return null;
    }

    /**
     * Ottiene i risultati della query di un album
     *
     * @param result risultato della query
     * @return oggetto album
     * @throws SQLException
     */
    private Album getAlbumDetails(ResultSet result) throws SQLException {
        List<String> musicians = new ArrayList<>();
        List<String> instruments = new ArrayList<>();
        List<String> songs = new ArrayList<>();

        Album album = new Album(
                result.getInt("id"),
                result.getString("titolo"),
                result.getString("titolare"),
                result.getString("copertina"),
                result.getInt("prezzo"),
                result.getDate("data"),
                result.getString("genere"),
                musicians,
                instruments,
                songs
        );

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM musicisti_cd INNER JOIN musicisti ON musicista = musicisti.id WHERE cd = ?" );
        preparedStatement.setInt(1, album.getId());
        ResultSet queryResult = preparedStatement.executeQuery();

        while (queryResult.next()) {
            musicians.add(queryResult.getString("nome"));
            instruments.add(queryResult.getString("strumento"));
        }

        preparedStatement = connection.prepareStatement( "SELECT * FROM brani WHERE cd = ?");
        preparedStatement.setInt(1, album.getId());
        queryResult = preparedStatement.executeQuery();

        while (queryResult.next()) {
            songs.add(queryResult.getString("titolo"));
        }
        return album;
    }

}
