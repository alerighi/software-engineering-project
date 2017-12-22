package it.alerighi.shop;

/**
 * Classe che rappresenta il magazzino 
 * 
 * @author ale
 */
public interface Warehouse {
	
	/**
	 * Aggiunge un album al magazzino
	 * 
	 * @param album album da aggiungere al magazzino
	 * @param quantity quantità di pezzi da aggiungere
	 */
	void addItem(Album album, int quantity);

	/**
	 * Rimuove un album dal magazzino 
	 * 
	 * @param album da rimuovere
	 */
	void removeItem(Album album);
	
	/**
	 * Aggiorna la quantità di pezzi in magazzino 
	 * 
	 * @param album album da aggiornare
	 * @param quantity differenza di quantità da applicare (positiva o negativa)
	 */
	void updateQuantity(Album album, int quantity);
	
	/**
	 * Ottiene il numero di pezzi in magazzino 
	 * 
	 * @param album album di cui ottenere il numero di pezzi 
	 */
	int getQuantity(Album album);
	
}
