package ParkingLot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Ticket extends  BaseModel{
    private Vehicle vehicle;
    private VehicleType vehicleType;
    private Operator operator;
    private Gate gate;
    private Date entryTime;
    private ParkingLot parkingLot;
    private ParkingSlot parkingSlot;
}
