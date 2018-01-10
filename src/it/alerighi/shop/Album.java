package it.alerighi.shop;

import java.util.Date;
import java.util.List;

/**
 * Classe che rappresenta un album nel sistema
 *
 * @author Alessandro Righi
 */
public class Album {

    /**
     * Il titolo dell'album
     */
    private final String title;

    /**
     * L'autore dell'album
     */
    private final String author;

    /**
     * Il path all'immagine di copertina
     */
    private final String cover;

    /**
     * Il genere dell'album
     */
    private final String genre;

    /**
     * Array degli strumenti partecipanti
     */
    private final String[] instruments;

    /**
     * Array delle canzioni dell'album
     */
    private final String[] songs;

    /**
     * Array dei musicisti partecipanti
     */
    private final Musician[] musicians;

    /**
     * Data dalla quale l'album è in vendita
     */
    private final Date dateSinceOnSale;

    /**
     * Identificativo univoco dell'album
     */
    private final int id;

    /**
     * Prezzo dell'album
     */
    private final double price;


    /**
     * Costruisce un nuovo oggetto album
     *
     * @param id id dell'album
     * @param title titolo dell'album
     * @param author autore
     * @param cover path all'immagine di copertina
     * @param price prezzo
     * @param dateSinceOnSale data dalla quale è in vendita
     * @param genre genere musicale
     * @param musicians musicisti partecipanti
     * @param instruments strumenti partecipanti
     * @param songs canzoni contenute
     */
    public Album(int id, String title, String author, String cover, double price, Date dateSinceOnSale, String genre,
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
    public double getPrice() {
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
        return title;
    }
}
