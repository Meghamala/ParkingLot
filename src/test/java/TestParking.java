import exceptions.ParkingFullException;

public class TestParking {

    public static void main(String[] args) throws ParkingFullException {
        ParkingImpl parkingLot = ParkingImpl.getParkingLot();

        parkingLot.setParkingLot(10, 10);

        Vehicle vehicle = new Vehicle("Mh12", VehicleType.TWOWHEELER);

        Ticket ticket = parkingLot.park(vehicle);
        System.out.println(ticket);

        Vehicle vehicle2 = new Vehicle("Mazda", VehicleType.FOURWHEELER);

        Ticket ticket2 = parkingLot.park(vehicle2);
        System.out.println(ticket2);

    }

}