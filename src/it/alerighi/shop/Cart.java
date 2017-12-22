/**
 * 
 */
package it.alerighi.shop;

import java.util.*;

/**
 * Classe che rappresenta il carrello.
 * Design pattern: singleton
 * 
 * @author ale
 */
public class Cart {

	/**
	 * album contenuti nel carrello
	 */
	private Map<Album, Integer> items = new HashMap<>();

    /**
     * Importo totale degli album contenuti nel carrello
     */
	private int total = 0;

    /**
     * Lista degli osservatori del carrello
     */
	private List<Observer> observers = new ArrayList<>();

    /**
     * Instanza del carrello
     */
	private static final Cart instance = new Cart();
	
	/**
	 * Costruttore del carrello.
     * Costruttore privato perché uso il pattern singleton.
	 */
	private Cart() {
	}
	
	/**
	 * Ritorna l'instanza del carrello
	 * 
	 * @return istanza del carrello
	 */
	public static Cart getInstance() {
		return instance;
	}
	
	/**
	 * Aggiunge un album al carrello
	 * 
	 * @param album album da aggiungere al carrello
	 */
	public void add(Album album) {
		if (items.containsKey(album))
			items.put(album, items.get(album) + 1); // increase count
		else
			items.put(album, 1);
		total += album.getPrice();
		update();
	}
	
	/**
	 * Rimuove un album dal carrello
	 * 
	 * @param album
	 */
	public void remove(Album album) {
		if (!items.containsKey(album))
			return;
		if (items.get(album) == 1)
			items.remove(album);
		else
			items.put(album, items.get(album) - 1);
		total -= album.getPrice();
		update();
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
		return new ArrayList<>(items.keySet());
	}

	/**
	 * Ritorna un hashmap con gli album e la quantità
	 *
	 * @return map
	 */
	public Map<Album, Integer> getMap() {
		return items;
	}
	
	public int numberOfItems() {
		int result = 0;
		for (int i: items.values())
			result += i;
		return result;
	}
	
	/**
	 * Registra un osservatore 
	 * 
	 * @param o
	 */
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	/**
	 * Rimuove un osservatore
	 * 
	 * @param o
	 */
	public void deleteObserver(Observer o) {
		observers.remove(o);
	}
	
	/**
	 * Manda una notifica agli observer
	 */
	private void update() {
		for (Observer o: observers)
			o.update();
	}
	
	/**
	 * Ritorna una rappresentazione sottoforma di stringa del carrello
	 * 
	 * @return rappresentazione sottoforma di stringa del carrello
	 */
	@Override
	public String toString() {
		String result = "Elementi nel carrello:\n";
		for (Album album: items.keySet())
			result += album.getTitle() + "\n";
		return result;
	}
}
