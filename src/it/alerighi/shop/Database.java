package it.alerighi.shop;

import static it.alerighi.shop.Util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Classe che gestisce l'accesso al database.
 *
 * @author Alessandro Righi
 */
public final class Database {

    /**
     * Costruttore privato: classe non instanziabile
     */
	private Database() {}

    /**
     * Oggetto connessione
     */
    private static Connection connection = null;

    /**
     * Nome host del database
     */
    private static final String DB_HOST = "localhost";

    /**
     * Utente del database
     */
    private static final String DB_USER = "ale";

    /**
     * Password del database
     */
    private static final String DB_PASS = "ale96";

    /**
     * Nome del database
     */
    private static final String DB_NAME = "cdstore";

    /**
     * Users database
     */
    private static final Users usersDatabase;

    /**
     * Catalog database
     */
    private static final Catalog catalogDatabase;

    /*
     * Inizializza la connessione al database
     */
    static {
        Properties properties = new Properties();
        properties.setProperty("user", DB_USER);
        properties.setProperty("password", DB_PASS);
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://" + DB_HOST + "/" + DB_NAME, properties);
        } catch (SQLException e) {
            die("Impossibile stabilire una connessione con il database: " + e.getLocalizedMessage());

        }

        usersDatabase = new UsersDatabase(connection);
        catalogDatabase = new CatalogDatabase(connection);
    }

    /**
     * Ritorna un instanza di oggetto connessione al database
     *
     * @return instanza di oggetto connessione al database
     */
    public static Connection getConnection() {
    	return connection;
    }

    /**
     * Ottiene il database degli utenti
     *
     * @return database degli utenti
     */
    public static Users getUsersDatabase() {
        return usersDatabase;
    }

    /**
     * Ottiene il database del catalogo
     *
     * @return database del catalogo
     */
    public static Catalog getCatalogDatabase() {
        return catalogDatabase;
    }

}
