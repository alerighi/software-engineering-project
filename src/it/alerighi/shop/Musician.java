package it.alerighi.shop;

/**
 * Classe che rappresenta un musicista nel sistema
 * 
 * @author Alessandro Righi
 */
public class Musician {

	private final String name;
	private final String genre;
	private final int year;
	private final String[] instruments;
	private final int id;
	
	public Musician(int id, String name, String genre, int year, String[] instruments) {
		this.name = name;
		this.genre = genre;
		this.year = year;
		this.instruments = instruments;
		this.id = id;
	}
	
	public Musician(int id, String name, String genre, int year) {
		this(id, name, genre, year, null);
	}
	
	public String getName() {
		return name;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getYear() {
		return year;
	}
	
	public String[] getInstruments() {
		return instruments;
	}
	
	public int getId() {
		return id;
	}
}
