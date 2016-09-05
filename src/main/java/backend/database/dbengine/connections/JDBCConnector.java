package backend.database.dbengine.connections;

/**
 * THis is a common interface for connectors
 */
public interface JDBCConnector {
    /**
     * Use class instantilize driver
     */
    void initializeDriver();

}
