package backend.services;

import backend.database.dbtables.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by Dmitry on 05.09.2016.
 */
@Component("SessionsService")
public class SessionsService {
    @Autowired
    Session session;

    public int addSession(String filmName, String date) {
        return session.addSession(filmName, date);
    }

    public void displayAllSessions(String date)
    {
        try {
            session.displaySessions(date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
