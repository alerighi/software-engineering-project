package it.alerighi.shop;

import java.util.List;

/**
 * Interfaccia che rappresenta il catalogo del negozio di CD
 * 
 * @author Alessandro Righi
 */
public interface Catalog {
	
	/**
	 * Aggiunge un album al catalogo
	 * @param album album da aggiungere al catalogo
	 */
	void addAlbum(Album album);
	
	/**
	 * Ritorna la lista di album a catalogo
	 * @return lista di album a catalogo
	 */
	List<Album> getAlbums();
	
	/**
	 * Ritorna una lista di album con il dato titolo
	 * @param title titolo da ricercare
	 * @return lista di album con titolo simile al ricercato
	 */
	List<Album> getAlbumsByTitle(String title);
	
	/**
	 * Ritorna una lista di album con il dato genere
	 * @param genre genere da ricercare
	 * @return lista di album con genere simile al ricercato
	 */
	List<Album> getAlbumsByGenre(String genre);
	
	/**
	 * Ritorna una lista di album in cui suona il dato musicista
	 * @param musician musicista da ricercare
	 * @return lista di album in cui suona un musicista simile al ricercato
	 */
	List<Album> getAlbumsByMusician(String musician);
	
	/**
	 * Ritorna una lista di album con il dato autore
	 * @param author autore da ricercare
	 * @return lista di album che hanno come autore quello ricercato
	 */
	List<Album> getAlbumsByAuthor(String author);
	
	/**
	 * Ritorna una lista di album con un prezzo minore a quello dato 
	 * @param price prezzo massimo da ricercare
	 * @return lista di album con prezzo minore del selezionato
	 */
	List<Album> getAlbumsByPrice(int price);
}
