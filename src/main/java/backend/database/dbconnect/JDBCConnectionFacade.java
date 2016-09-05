package backend.database.dbconnect;

import backend.database.dbengine.connections.JDBCDBSQLiteManager;
import backend.database.dbengine.connections.JDBCTableManager;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;

/**
 * This is a facade method that composes mssql sqlite, sqlite manager and table manager methods
 */
@Component("jdbcConnectionFacade")
public class JDBCConnectionFacade {
    private JDBCDBSQLiteManager jdbcdbsqLiteManager = new JDBCDBSQLiteManager();
    private JDBCTableManager tableManager;

    /**
     * Executes sql query
     *
     * @param sqlQuery     - sql query
     * @param tableManager - table manager
     */
    public void executeDataTableQuery(String sqlQuery, JDBCTableManager tableManager) {
        tableManager.execute(sqlQuery);
    }

    /**
     * Executes sql query using default table manager
     */
    public void executeDataTableQuery(String sqlQuery) {
        executeDataTableQuery(sqlQuery, getTableManager());
    }

    /**
     * Executes update sql query
     *
     * @param sqlQuery - query
     */
    public void updateDataTableQuery(String sqlQuery) {
        updateDataTableQuery(sqlQuery, getTableManager());
    }

    /**
     * Executes update sql query using specified table manager
     *
     * @param sqlQuery
     * @param tableManager
     */
    public void updateDataTableQuery(String sqlQuery, JDBCTableManager tableManager) {
        tableManager.executeUpdate(sqlQuery);
    }

    /**
     * Execute insert statement
     */
    public Integer executeInsert(String sqlQuery) {
        return tableManager.insertQuery(sqlQuery);
    }

    /**
     * Returns table manager
     *
     * @return table manager
     */
    public JDBCTableManager getTableManager() {
        if (this.tableManager != null)
            return this.tableManager;
        this.tableManager = new JDBCTableManager(jdbcdbsqLiteManager.getConnection());
        return this.tableManager;
    }

    public ResultSet executeGet(String sqlQuery) {
        return tableManager.executeQuery(sqlQuery);
    }
}
