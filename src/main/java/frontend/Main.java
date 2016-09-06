package frontend;

import backend.entities.Person;
import backend.services.AddBookingService;
import backend.services.SessionsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springfeatures.TIcketingConfiguration;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Dmitry on 04.09.2016.
 */
public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static ApplicationContext appContext = new AnnotationConfigApplicationContext(TIcketingConfiguration.class);

    public static void main(String[] args) throws SQLException {

        do {
            System.out.println();
            System.out.println("Please specify an option you wish: 1) Add session; 2) List all sessions; " +
                    "3) Book ticket; 4) Booked ticket");
            switch (input.nextLine()) {
                case "1":
                    addSession();
                    break;
                case "2":
                    System.out.println("Specify date");
                    appContext.getBean(SessionsService.class).displayAllSessions(input.nextLine());
                    break;
                case "3":
                    bookSession();
                    break;
                case "4":
                    System.out.println("Specify ticket number");
                    appContext.getBean(AddBookingService.class).getBookedTicket(input.nextLine());
                    break;
                case "5":
                    System.out.println("Specify booking number to remove ticket");
                    appContext.getBean(AddBookingService.class).removeBookedTicket(input.nextLine());
                    break;
                case "exit":
                    ((AnnotationConfigApplicationContext) appContext).close();
                    return;
            }
        } while (true);

    }

    private static void bookSession() {
        System.out.println();
        System.out.println("Please specify following information:" +
                "Person Name, Person Last Name, " +
                "Date, BookingNo, Place, " +
                "Integer price");
        AddBookingService bookingService = appContext.getBean(AddBookingService.class);
        Person person = appContext.getBean(Person.class);
        person.setPersonName(input.nextLine());
        person.setPersonLastName(input.nextLine());
        try {
            bookingService.correctlyBookTicket(input.nextLine(), input.nextLine(), input.nextInt(), person,
                    input.nextInt());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addSession() {
        System.out.println();
        System.out.println("Please specify following information: Film Name, Date");
        SessionsService sessionsService = appContext.getBean(SessionsService.class);
        sessionsService.addSession(input.nextLine(), input.nextLine());
        return;
    }
}
