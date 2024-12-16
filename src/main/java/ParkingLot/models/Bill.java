package ParkingLot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Bill extends BaseModel{
    private Date exitDate;
    private int amount;
    private Gate gate;
    private Operator operator;
    private Ticket ticket;
}
