package ParkingLot.dto;

import ParkingLot.models.Ticket;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class IssueTicketResponseDTO {
    private Ticket ticket;
    private ResponseStatus responseStatus;
    private String failureMessage;

}
