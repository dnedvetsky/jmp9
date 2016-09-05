package springfeatures;

import backend.database.dbtables.Session;
import backend.database.dbtables.TicketQueries;
import backend.entities.Person;
import backend.entities.Ticket;
import backend.services.AddBookingService;
import backend.services.SessionsService;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Dmitry on 04.09.2016.
 */
@Configuration
@ComponentScan
@PropertySource("backend/database/dbtables/defaultTablesProperty.properties")
@Import({DatabaseConnectionConfiguration.class, NightlyPricesConfiguration.class, DailyPricesConfiguration.class})
public class TIcketingConfiguration {
    @Bean
    @Scope("prototype")
    public Person person() {
        return new Person();
    }

    @Bean(initMethod = "init")
    public Session session() {
        return new Session();
    }

    @Bean(initMethod = "init")
    public TicketQueries ticketQueries() {
        return new TicketQueries();
    }

    @Bean
    public AddBookingService addBookingService() {
        return new AddBookingService();
    }

    @Bean
    public Ticket Ticket() {
        return new Ticket();
    }

    @Bean
    public SessionsService sessionsService() {
        return new SessionsService();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setIgnoreUnresolvablePlaceholders(true);
        return configurer;
    }

}
