import ChargeStrategy.ParkingChargeStrategy;
import exceptions.InvalidVehicleNumberException;
import exceptions.ParkingFullException;
import java.util.*;
public class ParkingImpl implements Parking{

    private static ParkingImpl parkingLot;
    private List<Slot> twoWheelerSlots;
    private List<Slot> fourWheelerSlots;

    private ParkingImpl(){
        this.twoWheelerSlots= new ArrayList<>();
        this.fourWheelerSlots = new ArrayList<>();
    }

    // singleton pattern for parking lot
    public static ParkingImpl getParkingLot(){
        if(parkingLot == null){
            parkingLot = new ParkingImpl();
        }
        return parkingLot;
    }

    public void setParkingLot(int noOfTwoWheelerSlots, int noOfFourWheelerSlots){

        for(int i=0; i<noOfTwoWheelerSlots; i++){
            twoWheelerSlots.add(new Slot(i+100));
        }
        for(int i=0; i<noOfFourWheelerSlots; i++){
            fourWheelerSlots.add(new Slot(i+200));
        }

    }

    @Override
    public Ticket park(Vehicle vehicle) throws ParkingFullException {
        Slot availableSlot;
        if(vehicle.getVehicleType().equals(VehicleType.FOURWHEELER)){
            availableSlot = getAvailableFourWheelerSlot();
        }else{
            availableSlot = getAvailableTwoWheelerSlot();
        }
        availableSlot.occupySlot(vehicle);
        Ticket ticket = new Ticket(availableSlot.getSlotNumber(), vehicle.getLicensePlate(), new Date(), vehicle.getVehicleType());
        return ticket;
    }

    @Override
    public Ticket unpark(Ticket ticket, ParkingChargeStrategy parkingChargeStrategy) throws InvalidVehicleNumberException {
        return null;
    }

    private Slot getAvailableTwoWheelerSlot() throws ParkingFullException {

        for (Slot s : twoWheelerSlots) {
            if (s.isEmpty()) {
                return s;
            }
        }
        throw new ParkingFullException("No Empty slots");
    }

    private Slot getAvailableFourWheelerSlot() throws ParkingFullException{

        for(Slot s: fourWheelerSlots){
            if(s.isEmpty()){
                return s;
            }
        }
        throw new ParkingFullException("No Empty slots");
    }
}
