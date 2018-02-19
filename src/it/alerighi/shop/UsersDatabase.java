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
public final class UsersDatabase implements Users {

    /**
     * connessione al database
     */
	private final Connection connection;

    /**
     * Costruttore database utenti
     *
     * @param connection connessione dal database
     */
	public UsersDatabase(Connection connection) {
	    this.connection = connection;
    }
	
	/**
     * Funzione che autentica un utente
     *
     * @param username nome utente
     * @param password password
     * @return ritorna true nel caso l'utente sia autenticato, false altrimenti
     */
    public User authenticateUser(String username, String password) {
        String query = "SELECT * FROM clients WHERE username = ? AND password = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (!result.next())
                return null;
            return new User(
                    result.getString("username"),
                    result.getString("password"),
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getString("city"),
                    result.getString("tax_code"),
                    result.getString("phone"),
                    result.getString("mobile_phone"),
                    result.getBoolean("is_admin")
            );
        } catch (SQLException e) {
            die("Errore query: " + e.getLocalizedMessage());
        }

        return null;
    }

    /**
     * Aggiunge un nuovo utente al sistema
     *
     * @param user utente da aggiungere
     * @return true se l'aggiunta dell'utente è andata a buon fine, false se l'utente è già stato utilizzato
     */
    public boolean addUser(User user) {
        String query2 =
                "INSERT INTO clients (tax_code, username, password, first_name, last_name, city, phone, mobile_phone) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query2)) {
            statement.setString(1, user.getTaxCode());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getCity());
            statement.setString(7, user.getPhone());
            statement.setString(8, user.getMobile());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Elimina un utente dal sistema
     *
     * @param user utente da eliminare
     * @return true se l'utente è stato eliminato, false se l'utente non esisteva
     */
    public boolean deleteUser(User user) {
        String query = "DELETE FROM clients WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            die("Errore query");
        }
        return false;
    }
}
