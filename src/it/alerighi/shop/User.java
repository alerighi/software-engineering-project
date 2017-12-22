package it.alerighi.shop;

/**
 * Rappresenta un utente nel sistema
 * 
 * @author Alessandro Righi
 */
public class User {

	/**
	 * Nome utente
	 */
	private final String username;

	/**
	 * Password
	 */
	private final String password;

	/**
	 * Nome
	 */
	private final String firstName;

	/**
	 * Cognome
	 */
	private final String lastName;

	/**
	 * Città di residenza
	 */
	private final String city;

	/**
	 * Codice fiscale
	 */
	private final String fiscalCode;

	/**
	 * Telefono fisso
	 */
	private final String phone;

	/**
	 * Telefono cellulare
	 */
	private final String mobile;

	/**
	 * Costruisce un nuovo utente
	 * 
	 * @param username nome utente
	 * @param password password
	 * @param firstName nome
	 * @param lastName cognome
	 * @param city città di residenza
	 * @param fiscalCode codice fiscale
	 * @param phone telefono fisso
	 * @param mobile telefono cellulare
	 */
	public User(String username, String password, String firstName, String lastName, String city, String fiscalCode,
			String phone, String mobile) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.fiscalCode = fiscalCode;
		this.phone = phone;
		this.mobile = mobile;
	}


	/**
	 * Ottiene l'username
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * Ottiene la password
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * Ottiene il nome
	 *
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * Ottiene il cognome
	 *
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * Ottiene la città
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * Ottiene il codice fiscale
	 *
	 * @return the fiscalCode
	 */
	public String getFiscalCode() {
		return fiscalCode;
	}


	/**
	 * Ottiene il telefono
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}


	/**
	 * Ottiene il cellulare
	 *
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", city=" + city + ", fiscalCode=" + fiscalCode + ", phone=" + phone + ", mobile=" + mobile
				+ "]";
	}

}
