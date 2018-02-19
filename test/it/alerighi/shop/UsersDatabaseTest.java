package it.alerighi.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersDatabaseTest {

    @Test
    void userDatabaseTest() {
        Users db = Database.getUsersDatabase();
        User newUser = new User("test","test", "Test", "Test", "Test", "00","00", "00", false);
        boolean ok = db.addUser(newUser);
        assert (ok);
        User authenticatedUser = db.authenticateUser("test", "test");
        assert (authenticatedUser != null);
        ok = db.deleteUser(newUser);
        assert (ok);
    }
}