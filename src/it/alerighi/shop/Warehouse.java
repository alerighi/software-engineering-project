package it.alerighi.shop;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe che rappresenta il magazzino 
 * 
 * @author ale
 */
public class Warehouse {
	
	private Map<Album, Integer> items = new HashMap<>();
	
	private static Warehouse instance = null;
	
	/**
	 * Costruttore privato per la classe
	 */
	private Warehouse() {}
	
	/**
	 * Ottiene un istanza della classe
	 * 
	 * @return istanza della classe
	 */
	public static Warehouse getInstance() {
		if (instance == null)
			instance = new Warehouse();
		return instance;
	}
	
	/**
	 * Aggiunge un album al magazzino
	 * 
	 * @param album album da aggiungere al magazzino
	 * @param quantity quantità di pezzi da aggiungere
	 */
	public void addItem(Album album, int quantity) {
		items.put(album, quantity);
	}
	
	/**
	 * Rimuove un album dal magazzino 
	 * 
	 * @param album da rimuovere
	 */
	public void removeItem(Album album) {
		items.remove(album);
	}
	
	/**
	 * Aggiorna la quantità di pezzi in magazzino 
	 * 
	 * @param album album da aggiornare
	 * @param quantity differenza di quantità da applicare (positiva o negativa)
	 */
	public void updateQuantity(Album album, int quantity) {
		int value = items.get(album) + quantity;
		items.put(album, value);
	}
	
	/**
	 * Ottiene il numero di pezzi in magazzino 
	 * 
	 * @param album album di cui ottenere il numero di pezzi 
	 */
	public void getQuantity(Album album) {
		items.get(album);
	}

}
