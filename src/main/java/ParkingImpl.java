import ChargeStrategy.ParkingChargeStrategy;
import exceptions.InvalidVehicleNumberException;
import exceptions.ParkingFullException;

import java.time.LocalDateTime;
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
    public double unpark(Ticket ticket, ParkingChargeStrategy parkingChargeStrategy) throws InvalidVehicleNumberException {
        Slot slot;
        if(ticket.getVehicleType().equals(VehicleType.FOURWHEELER)){
            slot= getFourWheelerSlotByVehicle(ticket.getLicensePlate());
        }
        else {
            slot = getTwoWheelerSlotByVehicle(ticket.getLicensePlate());
        }
        slot.vacateSlot();
        int hours = getHoursParked(ticket.getDate(), new Date());
        return parkingChargeStrategy.getParkingCharge(hours);
    }

    private int getHoursParked(Date startDate, Date endDate) {
        long secs = (endDate.getTime() - startDate.getTime())/1000;
        return (int)(secs/3600);
    }

    private Slot getTwoWheelerSlotByVehicle(String licensePlate) throws InvalidVehicleNumberException  {
        for(Slot s: twoWheelerSlots){
            Vehicle v = s.getParkedVehicle();
            if(v.getLicensePlate().equals(licensePlate)){
                return s;
            }
        }
        throw new InvalidVehicleNumberException("The vehicle parking is not found");
    }

    private Slot getFourWheelerSlotByVehicle(String licensePlate) throws InvalidVehicleNumberException {
        for(Slot s: fourWheelerSlots){
            Vehicle v = s.getParkedVehicle();
            if(v.getLicensePlate().equals(licensePlate)){
                return s;
            }
        }
        throw new InvalidVehicleNumberException("The vehicle parking is not found");
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
