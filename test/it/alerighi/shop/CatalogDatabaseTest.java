package it.alerighi.shop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatalogDatabaseTest {

    @Test
    void getAlbums() {
        List<Album> list = Database.getCatalogDatabase().getAlbums();
        assert(list != null);
    }

    @Test
    void getAlbumsByTitle() {
        List<Album> list = Database.getCatalogDatabase().getAlbumsByTitle("The");
        assert(list != null);
    }

    @Test
    void getAlbumsByGenre() {
        List<Album> list = Database.getCatalogDatabase().getAlbumsByGenre("rock");
        assert(list != null);
    }

    @Test
    void getAlbumsByMusician() {
        List<Album> list = Database.getCatalogDatabase().getAlbumsByMusician("David");
        assert(list != null);
    }

    @Test
    void getAlbumsByAuthor() {
        List<Album> list = Database.getCatalogDatabase().getAlbumsByAuthor("Pink");
        assert(list != null);
    }

    @Test
    void getAlbumsByPrice() {
        List<Album> list = Database.getCatalogDatabase().getAlbumsByPrice(20);
        assert(list != null);
    }
}