package ParkingLot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupportedVehicleType  extends BaseModel{

    private VehicleType vehicleType;
    private int capacity;
}
