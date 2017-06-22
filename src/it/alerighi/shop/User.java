package it.alerighi.shop;

/**
 * Rappresenta un utente nel sistema
 * 
 * @author Alessandro Righi
 */
public class User {
		
	private final String username;
	private final String password;
	private final String firstName;
	private final String lastName;
	private final String city; 
	private final String fiscalCode;
	private final String phone;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @return the fiscalCode
	 */
	public String getFiscalCode() {
		return fiscalCode;
	}


	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}


	/**
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
