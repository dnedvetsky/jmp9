package backend.database.dbengine.connections;


import org.springframework.stereotype.Component;

/**
 * Initiate usage of SQLITE driver
 */
@Component("JDBCSqliteConnector")
public class JDBCSqliteConnector implements JDBCConnector {
    public void initializeDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
