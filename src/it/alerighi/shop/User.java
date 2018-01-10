package it.alerighi.shop;

/**
 * Rappresenta un utente nel sistema
 * 
 * @author Alessandro Righi
 */
public final class User {

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
	private final String taxCode;

	/**
	 * Telefono fisso
	 */
	private final String phone;

	/**
	 * Telefono cellulare
	 */
	private final String mobile;

    /**
     * Is user an admin
     */
	private final boolean isAdmin;

	/**
	 * Costruisce un nuovo utente
	 * 
	 * @param username nome utente
	 * @param password password
	 * @param firstName nome
	 * @param lastName cognome
	 * @param city città di residenza
	 * @param taxCode codice fiscale
	 * @param phone telefono fisso
	 * @param mobile telefono cellulare
     * @param isAdmin indica se l'utente è amministratore
	 */
	public User(String username, String password, String firstName, String lastName, String city, String taxCode,
			String phone, String mobile, boolean isAdmin) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.taxCode = taxCode;
		this.phone = phone;
		this.mobile = mobile;
		this.isAdmin = isAdmin;
	}


	/**
	 * Ottiene l'username
	 *
	 * @return the username
	 */
	public String getUsername() {
		if (isAdmin)
		    return username + "*";
		else
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
	 * @return the taxCode
	 */
	public String getTaxCode() {
		return taxCode;
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
     * Ottiene se l'utente è amministratore
     *
     * @return true se l'utente è amministratore
     */
    public boolean isAdmin() {
        return isAdmin;
    }

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", city=" + city + ", taxCode=" + taxCode + ", phone=" + phone + ", mobile=" + mobile
				+ "]";
	}

}
