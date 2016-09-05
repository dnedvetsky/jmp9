package backend.database.dbtables;

import backend.database.dbconnect.JDBCConnectionFacade;
import backend.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * This will be ticket queries to work with tickets
 */
@Service("ticketQueriesService")
public class TicketQueries {
    @Autowired
    private JDBCConnectionFacade tableManager;

    @Value("${defaultTicketsTableCreation}")
    private String defaultTableCreation;
//            "CREATE TABLE IF NOT EXISTS Tickets(id INTEGER PRIMARY KEY ASC, BookingNumber TEXT, Place INTEGER, SessionID INTEGER, PersonName TEXT, PersonLastName TEXT, Price INTEGER);";

    private void init() {
        tableManager.executeDataTableQuery("DROP TABLE IF EXISTS Tickets;");
        createDefaultSessionsTable();
    }

    private void createDefaultSessionsTable() {
        tableManager.executeDataTableQuery(defaultTableCreation);
    }

    public Integer addTicketBooking(String bookingNo, Integer place, Integer sessionID,
                                    Person booker, Integer price) {
        Integer results = tableManager.executeInsert(String.format(
                "INSERT INTO Tickets (BookingNumber, Place, SessionID, PersonName, PersonLastName, Price)" +
                        "VALUES ('%s', %d, %d, '%s', '%s', %d);", bookingNo, place, sessionID, booker.getPersonName(),
                booker.getPersonLastName(), price));
        return results;
    }

    public void getTicket(String bookingNo) throws SQLException {
        ResultSet results = tableManager.executeGet("SELECT * FROM Tickets, " +
                "Sessions WHERE Tickets.SessionID=Sessions.id AND Tickets.BookingNumber = '" + bookingNo + "';");

        while (results.next()) {
            System.out.println(results.getString("BookingNumber"));
            System.out.println(results.getString("Place"));
            System.out.println(results.getString("PersonName"));
            System.out.println(results.getString("PersonLastName"));
            System.out.println(results.getString("FilmName"));
            System.out.println(results.getString("Date"));
            System.out.println(results.getString("Price"));
        }
        results.close();

    }
}
