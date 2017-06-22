package it.alerighi;

import java.util.Date;
import java.util.List;

/**
 * Classe che rappresenta un album nel sistema
 *
 * @author Alessandro Righi
 */
public class Album {
    private String title;
    private String author;
    private String cover;
    private List<String> songs;
    private String genre;
    private int price;
    private Date dateSinceOnSale;
    private List<String> musicians;
    private List<String> instruments;
    private int id;

    public Album(int id, String title, String author, String cover, int price, Date dateSinceOnSale, String genre,
                 List<String> musicians, List<String> instruments, List<String> songs) {
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

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCover() {
        return cover;
    }

    public List<String> getSongs() {
        return songs;
    }

    public int getPrice() {
        return price;
    }

    public Date getDateSinceOnSale() {
        return dateSinceOnSale;
    }

    public List<String> getMusicians() {
        return musicians;
    }

    public List<String> getInstruments() {
        return instruments;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        String result  = "";
        result += "id = " + id + "\n";
        result += "Titolo = " + title + "\n";
        result += "Autore = " + author + "\n";
        result += "Prezzo = " + price + "\n";
        result += "Genere = " + genre + "\n";
        result += "Data messa in vendita = " + dateSinceOnSale + "\n";

        for (int i = 0; i < musicians.size(); i++)
            result += "Musicista " + musicians.get(i) + " strumento " + instruments.get(i) + "\n";

        result += "Brani:\n";
        for (String song: songs)
            result += song + "\n";

        return result;
    }
}
