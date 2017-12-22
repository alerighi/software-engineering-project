package it.alerighi.shop;

import static it.alerighi.shop.Util.die;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Classe che rappresenta il database degli utenti
 * 
 * @author Alessandro Righi
 */
public class UsersDatabase implements Users {

    /**
     * connessione al database
     */
	private Connection connection = DatabaseConnection.getConnection();
	
	/**
     * Funzione che autentica un utente
     *
     * @param username nome utente
     * @param password password
     * @return ritorna true nel caso l'utente sia autenticato, false altrimenti
     */
    public User authenticateUser(String username, String password) {
        String query = "SELECT * FROM utenti WHERE username = ? AND password = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (!result.next())
                return null;
            return createUserFromResultSet(result);
        } catch (SQLException e) {
            die("Errore query ");
        }

        return null;
    }

    /**
     * Costruisce un nuovo utente da un set risultato
     * @param result result set da cui estrapolare l'utente
     * @return ritorna l'utente selezionato
     * @throws SQLException errore SQL
     */
    private User createUserFromResultSet(ResultSet result) throws SQLException {
    	return new User(
    		result.getString("username"),
    		result.getString("password"),
    		result.getString("nome"),
    		result.getString("cognome"),
    		result.getString("residenza"),
    		result.getString("codice_fiscale"),
    		result.getString("telefono"),
    		result.getString("cellulare")
    	);
    }

    /**
     * Aggiunge un nuovo utente al sistema
     *
     * @param user utente da aggiungere
     * @return true se l'aggiunta dell'utente è andata a buon fine, false se l'utente è già stato utilizzato
     */
    public boolean addUser(User user) {
        String query = "SELECT * FROM utenti WHERE username = ?";
        String query2 = "INSERT INTO utenti (codice_fiscale, username, password, nome, cognome, residenza, telefono, cellulare) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
        	try (PreparedStatement statement = connection.prepareStatement(query)) {
        		statement.setString(1, user.getUsername());
        		ResultSet result = statement.executeQuery();
        		if (result.next()) // esiste già un utente con il nome selezionato
        			return false;
        	}
        	try (PreparedStatement statement = connection.prepareStatement(query2)) {
        		statement.setString(1, user.getFiscalCode());
        		statement.setString(2, user.getUsername());
        		statement.setString(3, user.getPassword());
        		statement.setString(4, user.getFirstName());
        		statement.setString(5, user.getLastName());
        		statement.setString(6, user.getCity());
        		statement.setString(7, user.getPhone());
        		statement.setString(8, user.getMobile());
        		statement.executeUpdate();
        		return true;
        	} 
        } catch (SQLException e) {
            die("Errore query");
        }

        return false;
    }

    /**
     * Elimina un utente dal sistema
     *
     * @param user utente da eliminare
     * @return true se l'utente è stato eliminato, false se l'utente non esisteva
     */
    public boolean deleteUser(User user) {
        String query = "DELETE FROM utenti WHERE username = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            die("Errore query");
        }
        return false;
    }

	
}
