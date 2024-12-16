package ParkingLot.models;

import ParkingLot.strategies.SlotAssignment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingLot extends BaseModel {

    private String name;
    private List<Gate> entryGate;
    private List<Gate> exitGate;
    private List<ParkingFloor> parkingFloors;
    private ParkingLotStatus parkingLotStatus;
    private SlotAssignmentStrategyType slotAssignmentStrategyType;
}
