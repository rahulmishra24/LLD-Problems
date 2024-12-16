package ParkingLot;

import ParkingLot.controller.TicketController;
import ParkingLot.dto.IssueTicketRequestDTO;
import ParkingLot.dto.IssueTicketResponseDTO;
import ParkingLot.dto.ResponseStatus;
import ParkingLot.models.VehicleType;
import ParkingLot.repositories.GateRepository;
import ParkingLot.repositories.ParkingLotRepository;
import ParkingLot.repositories.TicketRepository;
import ParkingLot.repositories.VehicleRepository;
import ParkingLot.services.TicketService;

public class Client {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();

        TicketService ticketService = new TicketService(gateRepository, parkingLotRepository, ticketRepository, vehicleRepository);

        TicketController ticketController = new TicketController(ticketService);
        IssueTicketRequestDTO requestDTO = new IssueTicketRequestDTO();

        requestDTO.setGateId(1);
        requestDTO.setVehicleNumber("DL 1VC 0001");
        requestDTO.setVehicleType(VehicleType.THREE_WHEELER);
        requestDTO.setOwnerName("Mohit sharma");

        IssueTicketResponseDTO responseDTO = ticketController.issueTicket(requestDTO);
        if(responseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println("Ticket Issued");
            System.out.println(responseDTO.getTicket().getParkingSlot().getSlotNumber());
        }
        else{
            System.out.println("Ticket is not generated due to " + responseDTO.getFailureMessage());
        }


        /*
        * Bill
        * new Bill(
        *
        *
        *
        *
        * */



    }

}


