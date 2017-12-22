package it.alerighi.shop;

/**
 * Classe che rappresenta un musicista nel sistema
 * 
 * @author Alessandro Righi
 */
public class Musician {

	/**
	 * Nome del musicista
	 */
	private final String name;

    /**
     * Genere principale suonato
     */
	private final String genre;

    /**
     * Anno di nascita
     */
	private final int year;

    /**
     * Strumenti suonati
     */
	private final String[] instruments;

    /**
     * Id del musicista
     */
	private final int id;

    /**
     * Costruisce un musicista
     *
     * @param id id
     * @param name nome
     * @param genre genere suonato
     * @param year anno di nascita
     * @param instruments strumenti suonati
     */
	public Musician(int id, String name, String genre, int year, String[] instruments) {
		this.name = name;
		this.genre = genre;
		this.year = year;
		this.instruments = instruments;
		this.id = id;
	}

    /**
     * Ottiene il nome del musicista
     *
     * @return nome del musicista
     */
	public String getName() {
		return name;
	}

    /**
     * Ottiene il genere  suonato dal musicista
     *
     * @return genere suonato dal musicista
     */
	public String getGenre() {
		return genre;
	}

    /**
     * Ottiene l'anno di nascita
     *
     * @return anno di nascita
     */
	public int getYear() {
		return year;
	}

    /**
     * Ottiene gli strumenti suonati
     *
     * @return strumenti suonati
     */
	public String[] getInstruments() {
		return instruments;
	}

    /**
     * ottiene l'id del musicista
     *
     * @return id del musicista
     */
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
