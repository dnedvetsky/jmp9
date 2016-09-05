package backend.database.dbtables;

import backend.database.dbconnect.JDBCConnectionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Dmitry on 02.09.2016.
 */
@Component
public class Session {
    @Autowired
    private JDBCConnectionFacade tableManager;

    private DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MM");

    @Value("${defaultSessionTableCreation}")
    private String defaultTableCreation;//= "CREATE TABLE IF NOT EXISTS Sessions(id INTEGER PRIMARY KEY ASC, FilmName TEXT, Date TEXT);";

    private void init() {
        tableManager.executeDataTableQuery("DROP TABLE IF EXISTS Sessions;");
        createDefaultSessionsTable();
    }

    private void createDefaultSessionsTable() {
        tableManager.executeDataTableQuery(defaultTableCreation);
    }

    public int addSession(String filmName, String date) {

        return tableManager.executeInsert(String.format("INSERT INTO Sessions(FilmName, Date) VALUES ('%s', '%s');", filmName,
                date));
    }

    public void displaySessions(String date) throws SQLException {
        ResultSet results = tableManager.executeGet("SELECT * FROM Sessions WHERE Date = '" + date + "';");
        while (results.next()) {
            System.out.println(results.getString("FilmName"));
        }
        results.close();
    }

    public int getSessionByDate(String date) throws SQLException {
        ResultSet results = tableManager.executeGet("SELECT * FROM Sessions WHERE Date = '" + date + "';");
        int id = results.getInt("id");
        while (results.next()) {
            System.out.println(results.getString("FilmName"));
        }
        results.close();
        return id;
    }

    public int getSessionByFilm(String filmName) throws SQLException {
        ResultSet result = tableManager.executeGet("SELECT * FROM Sessions WHERE FilmName = ;" + filmName + ";");
        int id = result.getInt("id");
        while (result.next()) {
            System.out.println(result.getString("Date"));
        }
        result.close();
        return id;
    }
}
