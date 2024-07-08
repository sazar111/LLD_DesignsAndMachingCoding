package ParkingLot.Dtos;

import ParkingLot.Models.Ticket;

public class IssueTicketResponseDto {
    ResponseStatus responseStatus;
    Ticket ticket;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
