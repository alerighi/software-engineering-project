/**
 * 
 */
package it.alerighi.shop;


import static it.alerighi.shop.Util.die;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ale
 *
 */
public class CatalogDatabase implements Catalog {

	/**
	 * Connessione al DB
	 */
	private final Connection connection;

	/**
	 * Costruttore database utenti
	 *
	 * @param connection
	 */
	public CatalogDatabase(Connection connection) {
		this.connection = connection;
	}
	
	 /**
     * Ottiene i risultati della query di un album
     *
     * @param result risultato della query
     * @return oggetto album
     * @throws SQLException eccezoine di accesso al database
     */
    private Album getAlbumByResultSet(ResultSet result) throws SQLException {
        int id = result.getInt("code");
        Object[][] musiciansAndInstruments = getMusiciansAndInstrumentsByAlbumId(id);
        return new Album(
                id,
                result.getString("title"),
                result.getString("author"),
                result.getString("cover_image"),
                result.getDouble("price"),
                result.getDate("date_since_on_sale"),
                result.getString("genre"),
                (Musician[]) musiciansAndInstruments[0],
                (String[]) musiciansAndInstruments[1],
                getSongsByAlbumId(id)
        );
    }

	/**
	 * Ottiene un array bidimensionale con associazione musicista/strumento suonato
	 * @param id id dell'album da considerare
	 * @return elenco di musicisti con relativo strumento che suonano nel dato album
	 * @throws SQLException eccezione sql
	 */
	private Object[][] getMusiciansAndInstrumentsByAlbumId(int id) throws SQLException {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(
    			"SELECT * FROM musicians, musician_cd WHERE musicians.name = musician_cd.musician AND musician_cd.cd = ?")) {
    		preparedStatement.setInt(1, id);
    		ResultSet queryResult = preparedStatement.executeQuery();
    		
    		List<Musician> musicians = new ArrayList<>();
    		List<String> instruments = new ArrayList<>();
    		while (queryResult.next()) {
    			musicians.add(new Musician(
    				queryResult.getString("name"),
    				queryResult.getString("main_genre"),
    				queryResult.getInt("year_of_birth"),
    				null
    			));
    			instruments.add(queryResult.getString("instrument"));
    		}
    		
    		return new Object[][] {
    				musicians.toArray(new Musician[musicians.size()]), 
    				instruments.toArray(new String[instruments.size()])
    		};
    	}
    }

    /**
     * Ottiene un array di canzoni partendo dall'id dell'album
     * @param id id dell'album
     * @return array delle canzoni in esso contenute
     * @throws SQLException eccezione sql
     */
    private String[] getSongsByAlbumId(int id) throws SQLException {
    	 try (PreparedStatement preparedStatement = connection.prepareStatement( "SELECT * FROM songs WHERE cd = ?")) {
    		 preparedStatement.setInt(1, id);
    		 ResultSet queryResult = preparedStatement.executeQuery();
         
    		 List<String> songs = new ArrayList<>();
    		 while (queryResult.next()) {
    			 songs.add(queryResult.getString("title"));
    		 }
    		 
    		 return songs.toArray(new String[songs.size()]);
    	 }
    }
    
	
	/**
	 * @see it.alerighi.shop.Catalog#addAlbum(it.alerighi.shop.Album)
	 */
	@Override
	public void addAlbum(Album album) {
		/* NOT IMPLEMENTED */
	}

	/**
	 * @see it.alerighi.shop.Catalog#getAlbums()
	 */
	@Override
	public List<Album> getAlbums() {
		List<Album> albums = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM CDs");
            while (result.next()) {
                albums.add(getAlbumByResultSet(result));
            }

        } catch (SQLException e) {
        	e.printStackTrace();
            die("Errore query ");
        }

        return albums;
	}

	/**
	 * @see it.alerighi.shop.Catalog#getAlbumsByTitle(java.lang.String)
	 */
	@Override
	public List<Album> getAlbumsByTitle(String title) {
		List<Album> albums = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM CDs WHERE title LIKE ?")) {
        	statement.setString(1, "%" + title + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                albums.add(getAlbumByResultSet(result));
            }

        } catch (SQLException e) {
            die("Errore query");
        }

        return albums;
	}

	/**
	 * @see it.alerighi.shop.Catalog#getAlbumsByGenre(java.lang.String)
	 */
	@Override
	public List<Album> getAlbumsByGenre(String genre) {
		List<Album> albums = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM CDs WHERE genre LIKE ?")) {
        	statement.setString(1, "%" + genre + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                albums.add(getAlbumByResultSet(result));
            }

        } catch (SQLException e) {
            die("Errore query");
        }

        return albums;
	}

    /**
     * @see it.alerighi.shop.Catalog#getAlbumsByMusician(String)
     */
	@Override
	public List<Album> getAlbumsByMusician(String musician) {
		List<Album> albums = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
        		"SELECT CDs.* FROM CDs, musician_cd WHERE musician_cd.cd = CDs.code AND musician_cd.musician LIKE ?")) {
        	statement.setString(1, "%" + musician + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                albums.add(getAlbumByResultSet(result));
            }

        } catch (SQLException e) {
            die("Errore query");
        }

        return albums;
	}

    /**
     * @see it.alerighi.shop.Catalog#getAlbumsByAuthor(String)
     */
	@Override
	public List<Album> getAlbumsByAuthor(String author) {
		List<Album> albums = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM CDs WHERE author LIKE ?")) {
        	statement.setString(1, "%" + author + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                albums.add(getAlbumByResultSet(result));
            }

        } catch (SQLException e) {
            die("Errore query");
        }

        return albums;
	}

    /**
     * @see it.alerighi.shop.Catalog#getAlbumsByPrice(int)
     */
    @Override
	public List<Album> getAlbumsByPrice(int price) {
		List<Album> albums = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM CDs WHERE price < ?")) {
        	statement.setInt(1, price);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                albums.add(getAlbumByResultSet(result));
            }

        } catch (SQLException e) {
            die("Errore query");
        }

        return albums;
	}

}
