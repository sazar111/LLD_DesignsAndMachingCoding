package ParkingLot.Controllers;

import ParkingLot.Dtos.IssueTicketRequestDto;
import ParkingLot.Dtos.IssueTicketResponseDto;
import ParkingLot.Dtos.ResponseStatus;
import ParkingLot.Models.Ticket;
import ParkingLot.Services.TicketService;

public class TicketController {
    TicketService ticketService;

    TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto ticketRequestDto) {
        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();
        try {
            Ticket ticket = ticketService.issueTicket(
                    ticketRequestDto.getGateId(),
                    ticketRequestDto.getOwnerName(),
                    ticketRequestDto.getVehicleNumber(),
                    ticketRequestDto.getVehicletype()
            );
            issueTicketResponseDto.setTicket(ticket);
            issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception ex){
            issueTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return issueTicketResponseDto;
    }

}
