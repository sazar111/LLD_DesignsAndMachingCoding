package ParkingLot.Repositories;

import ParkingLot.Models.Ticket;

import java.util.HashMap;
import java.util.Optional;

public class TicketRepository {
    HashMap<Long, Ticket> tickets = new HashMap<Long,Ticket>();
    Long lastTicketId=0L;

    public Optional<Ticket> getTicketFromId(long id) {
        return Optional.ofNullable(tickets.get(id));
    }

    public Ticket addTicket(Ticket ticket) {
        if(ticket.getId()==null){
            lastTicketId++;
            ticket.setId(lastTicketId);
            tickets.put(ticket.getId(), ticket);
            return tickets.get(ticket.getId());
        }
        tickets.put(ticket.getId(), ticket);
        return tickets.get(ticket.getId());
    }
}
