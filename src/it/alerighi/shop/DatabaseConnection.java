package it.alerighi.shop;

import static it.alerighi.shop.Util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che gestisce l'accesso al database.
 *
 * @author Alessandro Righi
 */
public class DatabaseConnection {

    /**
     * Costruttore privato: classe non instanziabile
     */
	private DatabaseConnection() {}

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
    private static final String DB_USER = "negozio";

    /**
     * Password del database
     */
    private static final String DB_PASS = "negozio";

    /**
     * Nome del database
     */
    private static final String DB_NAME = "NegozioCD";

    /**
     * Ritorna un instanza di oggetto connessione al database
     * @return instanza di oggetto connessione al database
     */
    public static Connection getConnection()  {
    	try {
    		if (connection == null || connection.isClosed())
    	        connection = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + "/" + DB_NAME + "?user=" + DB_USER + "&password=" + DB_PASS);
    		return connection;
    	} catch (SQLException e) {
    		die("Impossibile stabilire una connessione con il database");
    	}
    	return null;
    }

}
