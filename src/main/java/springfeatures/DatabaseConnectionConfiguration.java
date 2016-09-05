package springfeatures;

import backend.database.dbconnect.JDBCConnectionFacade;
import backend.database.dbengine.connections.JDBCDBSQLiteManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Dmitry on 04.09.2016.
 */
@Configuration
public class DatabaseConnectionConfiguration {

    @Bean
    public JDBCConnectionFacade jdbcConnectionFacade() {
        return new JDBCConnectionFacade();
    }

    @Bean(destroyMethod = "cleanUp")
    public static JDBCDBSQLiteManager JDBCDBSQLiteManager() {
        return new JDBCDBSQLiteManager();
    }

}
