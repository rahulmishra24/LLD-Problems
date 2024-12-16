package ParkingLot.strategies;

import ParkingLot.models.*;

public class RandomSlotAssignmentStrategy implements SlotAssignment {

    @Override
    public ParkingSlot assignSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for(ParkingFloor floor: parkingLot.getParkingFloors()){
            for(ParkingSlot slot:floor.getParkingSlots()){
                if(slot.getParkingSlotStatus().equals(ParkingSlotStatus.EMPTY) && slot.getVehicleType().equals(vehicleType)){
                    slot.setParkingSlotStatus(ParkingSlotStatus.FULL);
                    return slot;
                }
            }
        }
        return null;
    }
}
