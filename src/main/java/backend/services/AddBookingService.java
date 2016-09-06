package backend.services;

import backend.database.dbtables.Session;
import backend.database.dbtables.TicketQueries;
import backend.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by Dmitry on 04.09.2016.
 */
@Service("bookingService")
public class AddBookingService {
    @Autowired
    private Session session;
    @Autowired
    private TicketQueries ticketQueries;


    public void bookTicket(String filmName, String date, String bookingNo, Integer place,
                           Person booker, Integer price) {
        Integer id = session.addSession(filmName, date);
        ticketQueries.addTicketBooking(bookingNo, place, id, booker, price);
    }

    public void getBookedTicket(String bookingNo) {
        try {
            ticketQueries.getTicket(bookingNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBookedTicket(String bookingNo) {
        try {
            ticketQueries.removeTicket(ticketQueries.getTicket(bookingNo));
        } catch (SQLException e) {

        }
    }

    public void correctlyBookTicket(String date, String bookingNo, Integer place,
                                    Person booker, Integer price) throws SQLException {
        Integer id = session.getSessionByDate(date);
        ticketQueries.addTicketBooking(bookingNo, place, id, booker, price);
    }
}
