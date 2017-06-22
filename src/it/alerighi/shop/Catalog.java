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
	 * @param album
	 */
	public void addAlbum(Album album);
	
	/**
	 * Ritorna la lista di album
	 * @return
	 */
	public List<Album> getAlbums();
	
	/**
	 * Ritorna una lista di album con il dato titolo
	 * @param title
	 * @return
	 */
	public List<Album> getAlbumsByTitle(String title);
	
	/**
	 * Ritorna una lista di album con il dato genere
	 * @param genre
	 * @return
	 */
	public List<Album> getAlbumsByGenre(String genre);
	
	/**
	 * Ritorna una lista di album in cui suona il dato musicista
	 * @param musician
	 * @return
	 */
	public List<Album> getAlbumsByMusician(Musician musician);
	
	/**
	 * Ritorna una lista di album con il dato autore
	 * @param author
	 * @return
	 */
	public List<Album> getAlbumsByAuthor(String author);
	
	/**
	 * Ritorna una lista di album con un prezzo minore a quello dato 
	 * @param price
	 * @return
	 */
	public List<Album> getAlbumsByPrice(int price);
}
