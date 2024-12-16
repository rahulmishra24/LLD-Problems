package ParkingLot.strategies;

import ParkingLot.models.ParkingLot;
import ParkingLot.models.ParkingSlot;
import ParkingLot.models.Vehicle;
import ParkingLot.models.VehicleType;

public interface SlotAssignment {
    public ParkingSlot assignSlot(ParkingLot parkingLot, VehicleType vehicleType);
}
