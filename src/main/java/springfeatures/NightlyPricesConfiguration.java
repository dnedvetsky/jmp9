package springfeatures;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("dailyPrices")
@PropertySource("backend/database/dbtables/nightly.properties")
public class NightlyPricesConfiguration {
}