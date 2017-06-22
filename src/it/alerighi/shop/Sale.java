package it.alerighi.shop;

import java.util.Date;

/**
 * Classe che rappresenta una vendita nel sistema 
 * 
 * @author Alessandro Righi
 */
public class Sale {
	
	private final User user;
	private final Album[] items;
	private final int id;
	private final int total;
	private final Date date;
	private final String ip;
	private final String paymentMethod;
	private final String shipementMethod;
	
	/**
	 * Costruttore di una vendita 
	 * 
	 * @param user utente che ha effettuato la vendita
	 * @param items cd acquistati dall'utente
	 * @param id itentificativo univoco della vendita
	 * @param total totale della vendita
	 * @param date data in cui è stata effettuata la vendita
	 * @param ip indirizzo ip da cui è stata effettuata la vendita
	 * @param paymentMethod metodo di pagamento scelto
	 * @param shipementmethod metodo di speidizione scelto
	 */
	public Sale(User user, Album[] items, int id, int total, Date date, String ip, String paymentMethod,
			String shipementMethod) {
		this.user = user;
		this.items = items;
		this.id = id;
		this.total = total;
		this.date = date;
		this.ip = ip;
		this.paymentMethod = paymentMethod;
		this.shipementMethod = shipementMethod;
	}

	/**
	 * Ottiene l'utente che ha effettuato la vendita
	 * 
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Ottiene l'elenco degli oggetti acquistati
	 * 
	 * @return the items
	 */
	public Album[] getItems() {
		return items;
	}

	/**
	 * Ottiene l'identificatore univoco della vendita 
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Ottiene il prezzo totale della vendita 
	 * 
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Ottiene la data in cui è stata effettuata la vendita
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Ottiene l'ip da cui è stata effettuata la vendita
	 * 
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Ottiene il metodo di pagamento scelto 
	 * 
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Ottiene il metodo di spedizione scelto 
	 * 
	 * @return the shipementMethod
	 */
	public String getShipementMethod() {
		return shipementMethod;
	}
	
}
