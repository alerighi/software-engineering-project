package it.alerighi.shop;

public interface Users {
	
	/**
	 * Aggiunge un utente al database
	 * @param user
	 * @return true in caso di aggiunta con successo, false altrimenti
	 */
	boolean addUser(User user);
	
	/**
	 * Rimuove un utente dal database
	 * @param user
	 * @return true in caso di eliminazione con successo, false altrimenti
	 */
	boolean deleteUser(User user);

	/**
	 * Autentica un utente
	 * @param username
	 * @param password
	 * @return l'utente autenticato in caso di successo, null in caso di errore
	 */
	User authenticateUser(String username, String password);
}
