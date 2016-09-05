package springfeatures;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Dmitry on 05.09.2016.
 */
@Configuration
@Profile("dailyPrices")
@PropertySource("backend/database/dbtables/daily.properties")
public class DailyPricesConfiguration {
}
