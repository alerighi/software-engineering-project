package it.alerighi.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void getUsersDatabase() {
        Users userDb = Database.getUsersDatabase();
        assert(userDb != null);
    }

    @Test
    void getCatalogDatabase() {
        Catalog catalogDb = Database.getCatalogDatabase();
        assert(catalogDb != null);
    }
}