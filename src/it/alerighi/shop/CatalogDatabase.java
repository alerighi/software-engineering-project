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

	
	private final Connection connection = DatabaseConnection.getConnection();
	
	 /**
     * Ottiene i risultati della query di un album
     *
     * @param result risultato della query
     * @return oggetto album
     * @throws SQLException eccezoine di accesso al database
     */
    private Album getAlbumByResultSet(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        Object[][] musiciansAndInstruments = getMusiciansAndInstrumentsByAlbumId(id);
        return new Album(
                id,
                result.getString("titolo"),
                result.getString("titolare"),
                result.getString("copertina"),
                result.getInt("prezzo"),
                result.getDate("data"),
                result.getString("genere"),
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
    			"SELECT * FROM musicisti_cd INNER JOIN musicisti ON musicista = musicisti.id WHERE cd = ?")) {
    		preparedStatement.setInt(1, id);
    		ResultSet queryResult = preparedStatement.executeQuery();
    		
    		List<Musician> musicians = new ArrayList<>();
    		List<String> instruments = new ArrayList<>();
    		while (queryResult.next()) {
    			musicians.add(new Musician(
    				queryResult.getInt("id"),
    				queryResult.getString("nome"),
    				queryResult.getString("genere"),
    				queryResult.getInt("anno"),
    				queryResult.getString("strumenti").split(";")
    			));
    			instruments.add(queryResult.getString("strumento"));
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
    	 try (PreparedStatement preparedStatement = connection.prepareStatement( "SELECT * FROM brani WHERE cd = ?")) {
    		 preparedStatement.setInt(1, id);
    		 ResultSet queryResult = preparedStatement.executeQuery();
         
    		 List<String> songs = new ArrayList<>();
    		 while (queryResult.next()) {
    			 songs.add(queryResult.getString("titolo"));
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
            ResultSet result = statement.executeQuery("SELECT * FROM cd");
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
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM cd WHERE titolo LIKE ?")) {
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
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM cd WHERE genere LIKE ?")) {
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
        		"SELECT cd.* FROM cd INNER JOIN musicisti_cd ON musicisti_cd.cd = cd.id INNER JOIN musicisti ON musicisti_cd.musicista = musicisti.id WHERE musicisti.nome LIKE ?")) {
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
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM cd WHERE titolare LIKE ?")) {
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
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM cd WHERE prezzo < ?")) {
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
