package backend.database.dbengine.connections;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class used to manage sqlite connection with the provided driver
 */
@Component("JDBCDBSQLiteManager")
public class JDBCDBSQLiteManager {
    private String url;
    private static String sqliteConnectionMarker = "jdbc:sqlite:";
    public Connection connection = null;

    /**
     * Use method to establish connection to database
     */
    public JDBCDBSQLiteManager() {
        this("default.db");
    }

    /**
     * Use constructor to establish connection to database with non-default DB name
     *
     * @param url - url to db to get and use as name for database file
     */
    public JDBCDBSQLiteManager(String url) {
        this.url = url;
        new JDBCSqliteConnector().initializeDriver();
        try {
            this.connection = DriverManager.getConnection(sqliteConnectionMarker + this.url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    /**
     * This method is used to set autocommit status for JDBC connection
     *
     * @param status - state of autocommit - true or false
     */
    public void setAutocommitStatus(boolean status) {
        try {
            connection.setAutoCommit(status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to get URL for BD file
     */
    public String getUrl() {
        return this.url;
    }

    public void cleanUp() throws SQLException {
        System.out.println("Closing connection to DB");
        this.connection.close();
    }
}
