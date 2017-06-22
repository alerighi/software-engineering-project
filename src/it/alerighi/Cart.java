/**
 * 
 */
package it.alerighi;

import java.util.*;


/**
 * Classe che rappresenta il carrello.
 * Design pattern: singleton
 * 
 * @author ale
 */
public class Cart {

	private List<Album> items = new ArrayList<>();
	private int total = 0;
	
	private static Cart instance = null;
	
	/**
	 * Costruttore del carrello
	 */
	private Cart() {
		
	}
	
	/**
	 * Ritorna l'instanza del carrello
	 * 
	 * @return istanza del carrello
	 */
	public static Cart getInstance() {
		if (instance == null)
			instance = new Cart();
		return instance;
	}
	
	/**
	 * Aggiunge un album al carrello
	 * 
	 * @param album album da aggiungere al carrello
	 */
	public void add(Album album) {
		items.add(album);
		total += album.getPrice();
	}
	
	/**
	 * Rimuove un album dal carrello
	 * 
	 * @param album
	 */
	public void remove(Album album) {
		items.remove(album);
		total -= album.getPrice();
	}
	
	/**
	 * Ottiene il prezzo totale degli elementi nel carrello
	 * 
	 * @return prezzo totale
	 */
	public int getTotal() {
		return total;
	}
	
	/**
	 * Ritorna gli album contenuti nel carrello
	 * 
	 * @return album contenuti nel carrello
	 */
	public List<Album> getItems() {
		return items;
	}
}
