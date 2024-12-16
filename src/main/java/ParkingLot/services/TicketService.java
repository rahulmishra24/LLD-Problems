package ParkingLot.services;

import ParkingLot.models.*;
import ParkingLot.repositories.GateRepository;
import ParkingLot.repositories.ParkingLotRepository;
import ParkingLot.repositories.TicketRepository;
import ParkingLot.repositories.VehicleRepository;
import ParkingLot.strategies.SlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository  gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    private VehicleRepository vehicleRepository;

    public TicketService(GateRepository gateRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository, VehicleRepository vehicleRepository){
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public Ticket issueTicket(int gateId,
                              String vehicleNumber,
                              String ownerName,
                              VehicleType vehicleType){

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());


        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()){
            throw new IllegalArgumentException("Gate Not Found");
        }

        Gate gate = gateOptional.get();
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());


        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleById(vehicleNumber);
        Vehicle vehicle;
        if(vehicleOptional.isEmpty()){
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicleRepository.save(vehicle);
        } else {
            vehicle = vehicleOptional.get();
        }

        Optional<ParkingLot> parkingLotOptional= parkingLotRepository.findParkinglotById(gate);
        ParkingLot parkingLot = parkingLotOptional.get();

        ParkingSlot parkingSlot =
                SlotAssignmentStrategyFactory
                        .getSlotAssignmentStrategy(parkingLot.getSlotAssignmentStrategyType())
                        .assignSlot(parkingLot , vehicleType);

        ticket.setParkingLot(parkingLot);
        ticketRepository.save(ticket);

        return ticket;
    }


}
