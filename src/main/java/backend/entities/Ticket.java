package backend.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Dmitry on 05.09.2016.
 */
@Component("Ticket")
public class Ticket {
    @Value("${priceMultiplyer:1}")
    private Integer ticketPrice;

    public Integer getTicketPrice(Integer price) {
        return price * ticketPrice;
    }
}
