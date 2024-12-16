package ParkingLot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseModel{
    public String vehicleNumber;
    public VehicleType vehicleType;
}
