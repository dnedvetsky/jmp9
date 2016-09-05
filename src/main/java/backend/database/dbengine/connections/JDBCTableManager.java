package backend.database.dbengine.connections;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Dmitry on 15.08.2016.
 */
@Component("JDBCTableManager")
public class JDBCTableManager {
    private Connection connection;
    private ResultSet getGeneratedKeys;

    /**
     * Constructor with specified connection
     *
     * @param connection - connection used for queries
     */
    public JDBCTableManager(Connection connection) {
        this.connection = connection;
    }

    /**
     * Used to execute update query
     *
     * @param sqlQuery - sql query for execution
     */
    public void executeUpdate(String sqlQuery) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
            System.out.println();
            System.out.println("Executed Update: " + sqlQuery);
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method used to execute query
     *
     * @param sqlQuery - sql query for execution
     */
    public ResultSet executeQuery(String sqlQuery) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void execute(String sqlQuery) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlQuery);
            System.out.println();
            System.out.println("Executed: " + sqlQuery);
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer insertQuery(String sqlQuery) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlQuery);
            ResultSet rs = statement.executeQuery("SELECT last_insert_rowid()");
            if (rs.next()) {
                return rs.getInt(1);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    ResultSet getGeneratedKeys() throws SQLException {
        if (getGeneratedKeys == null) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT last_insert_rowid();");
            return statement.getGeneratedKeys();
        }
        return getGeneratedKeys;
    }
}
