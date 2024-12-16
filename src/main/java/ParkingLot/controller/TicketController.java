package ParkingLot.controller;

import ParkingLot.dto.IssueTicketRequestDTO;
import ParkingLot.dto.IssueTicketResponseDTO;
import ParkingLot.dto.ResponseStatus;
import ParkingLot.models.Ticket;
import ParkingLot.services.TicketService;

public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO request){
        IssueTicketResponseDTO response = new IssueTicketResponseDTO();
        try{
            Ticket ticket = ticketService.issueTicket(
                    request.getGateId(),
                    request.getVehicleNumber(),
                    request.getOwnerName(),
                    request.getVehicleType()
            );
            response.setTicket(ticket);
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setFailureMessage(ex.getMessage());
        }
        return response;
    }
}
