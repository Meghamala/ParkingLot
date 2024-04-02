import ChargeStrategy.ParkingChargeStrategy;
import exceptions.InvalidVehicleNumberException;
import exceptions.ParkingFullException;

public interface Parking {

    public Ticket park(Vehicle vehicle) throws ParkingFullException;
    public Ticket unpark(Ticket ticket, ParkingChargeStrategy parkingChargeStrategy) throws InvalidVehicleNumberException;
}
