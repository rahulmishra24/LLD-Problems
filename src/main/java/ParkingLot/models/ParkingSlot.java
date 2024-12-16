package ParkingLot.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParkingSlot extends BaseModel{
    private String slotNumber;
    private ParkingSlotStatus parkingSlotStatus;
    private VehicleType vehicleType;
    private ParkingFloor parkingFloor;
}
