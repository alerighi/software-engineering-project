package it.alerighi;

import org.junit.jupiter.api.Test;

import it.alerighi.shop.Album;
import it.alerighi.shop.DatabaseConnection;

import javax.xml.crypto.Data;

import java.util.List;

import static it.alerighi.shop.Util.info;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by ale on 20/06/17.
 */
class DatabaseConnectionTest {
    @Test
    void authenticateUser() {
        DatabaseConnection conn = DatabaseConnection.getInstance();
        assertTrue(conn.authenticateUser("alerighi", "alerighi"));
        assertFalse(conn.authenticateUser("alerighi", "aaaa"));
        assertFalse(conn.authenticateUser("fdafa", "jadja"));
    }

    @Test
    void addDeleteUser() {
        DatabaseConnection conn = DatabaseConnection.getInstance();
        assertTrue(conn.addUser("ale", "ale96", "Ale", "Righi",
                "dd", "dd", "rr", "rr"));
        assertFalse(conn.addUser("ale", "ale96", "Ale", "Righi",
                "dd", "dd", "rr", "rr"));
        assertTrue(conn.deleteUser("ale"));
        assertFalse(conn.deleteUser("tizio"));
    }

    @Test
    void testGetAlbums() {
        DatabaseConnection conn = DatabaseConnection.getInstance();
        List<Album> albumList = conn.getAlbums();
        for (Album a : albumList)
            info(a.toString());
        assertTrue(albumList.size() >= 1);
    }
}