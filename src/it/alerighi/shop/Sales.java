package it.alerighi.shop;

import java.util.List;

/**
 * Interfaccia vendite
 */
public interface Sales {
	/**
	 * Aggiunge una vendita al database
	 * @param sale
	 */
	void addSale(Sale sale);
	
	/**
	 * Rimuove una vendita dal database
	 * @return
	 */
	List<Sale> getSales();
}
