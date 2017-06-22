package it.alerighi.shop;

import java.util.Date;
import java.util.List;

/**
 * Classe che rappresenta un album nel sistema
 *
 * @author Alessandro Righi
 */
public class Album {
	
    private final String title;
    private final String author;
    private final String cover;
    private final String genre;
    private final String[] instruments;
    private final String[] songs;
    private final Musician[] musicians;
    private final Date dateSinceOnSale;
    private final int id;
    private final int price;


    public Album(int id, String title, String author, String cover, int price, Date dateSinceOnSale, String genre,
                 Musician[] musicians, String[] instruments, String[] songs) {
        this.author = author;
        this.cover = cover;
        this.dateSinceOnSale = dateSinceOnSale;
        this.title = title;
        this.musicians = musicians;
        this.instruments = instruments;
        this.songs = songs;
        this.price = price;
        this.id = id;
        this.genre = genre;
    }

    /**
     * Ottiene il titolo dell'album
     * 
     * @return titolo dell'album
     */
    public String getTitle() {
        return title;
    }

    /**
     * Ottiene l'autore dell'album 
     * 
     * @return autore dell'album
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Ottiene la copertina dell'album
     * 
     * @return copertina dell'album
     */
    public String getCover() {
        return cover;
    }

    /**
     * Ottiene l'elenco delle canzioni dell'album
     * 
     * @return elenco canzoni dell'album
     */
    public String[] getSongs() {
        return songs;
    }

    /**
     * Ottiene il prezzo dell'album
     * 
     * @return prezzo dell'album
     */
    public int getPrice() {
        return price;
    }

    /**
     * Ottiene la data dalla quale l'album è in vendita
     * 
     * @return data dalla quale l'album è in vendita
     */
    public Date getDateSinceOnSale() {
        return dateSinceOnSale;
    }

    /**
     * Ottiene l'elenco dei musicisti partecipanti all'album
     * 
     * @return musicisti partecipanti all'album
     */
    public Musician[] getMusicians() {
        return musicians;
    }

    /**
     * Ottiene l'elenco degli strumenti suonati dai musicisti partecipanti all'album
     * 
     * @return elenco degli strumenti suonati
     */
    public String[] getInstruments() {
        return instruments;
    }

    /**
     * Ottiene l'id dell'album
     * 
     * @return id dell'album
     */
    public int getId() {
        return id;
    }

    /**
     * Ottiene il genere dell'album 
     * 
     * @return genere dell'album 
     */
    public String getGenre() {
        return genre;
    }

    
    /**
     * Ottiene una rappresentazione dell'album come stringa
     * 
     * @return rappresentazione dell'album come stringa 
     */
    @Override
    public String toString() {
        String result  = "";
        result += "id = " + id + "\n";
        result += "Titolo = " + title + "\n";
        result += "Autore = " + author + "\n";
        result += "Prezzo = " + price + "\n";
        result += "Genere = " + genre + "\n";
        result += "Data messa in vendita = " + dateSinceOnSale + "\n";

        for (int i = 0; i < musicians.length; i++)
            result += "Musicista " + musicians[i].getName() + " strumento " + instruments[i] + "\n";

        result += "Brani:\n";
        for (String song: songs)
            result += song + "\n";

        return result;
    }
}
