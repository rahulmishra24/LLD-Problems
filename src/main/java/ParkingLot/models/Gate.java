package ParkingLot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate {
    private String gateNumber;
    private Operator operator;
    private GateType gateType;
    private GateStatus gateStatus;
    private ParkingLot parkingLot;
}
