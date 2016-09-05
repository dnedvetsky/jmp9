package frontend;

import backend.entities.Person;
import backend.entities.Ticket;
import backend.services.AddBookingService;
import backend.services.SessionsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springfeatures.TIcketingConfiguration;

import java.sql.SQLException;

/**
 * Created by Dmitry on 04.09.2016.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(TIcketingConfiguration.class);
        Person person1 = appContext.getBean(Person.class);
        Ticket ticket = appContext.getBean(Ticket.class);
        person1.setPersonName("Vasily");
        person1.setPersonLastName("Turgenyev");
        Person person2 = appContext.getBean(Person.class);
        person2.setPersonName("Nikolay");
        person2.setPersonLastName("Sergeev");
        AddBookingService bookingService = appContext.getBean(AddBookingService.class);
        SessionsService sessionsService = appContext.getBean(SessionsService.class);
        sessionsService.addSession("Walkin Dead", "12.14.2015 10:00");
        sessionsService.addSession("Walkin Dead 1", "12.14.2015 10:00");
        sessionsService.addSession("Walkin Dead 2", "12.14.2015 10:00");
        sessionsService.addSession("Walkin Dead 3", "12.14.2015 10:00");
        System.out.println();
        sessionsService.displayAllSessions("12.14.2015 10:00");
//        bookingService.correctlyBookTicket("12.14.2015 10:00", "ABC33", 2,
//                person1, ticket.getTicketPrice(10));
//        bookingService.getBookedTicket("ABC33");

//        bookingService.bookTicket("Night of the Walking Dead 1", "12.13.2014 12:00", "ABC33", 2,
//                person1, ticket.getTicketPrice(10));
//        bookingService.bookTicket("Night of the Walking Dead 1", "12.13.2014 11:00", "ABC34", 3,
//                person2, ticket.getTicketPrice(33));
//        bookingService.getBookedTicket("ABC33");
//        bookingService.getBookedTicket("ABC34");
        ((AnnotationConfigApplicationContext) appContext).close();
    }
}
