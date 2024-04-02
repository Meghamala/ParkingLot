package ChargeStrategy;

public class FourWheelerWeekdayCharge implements ParkingChargeStrategy{


    @Override
    public double getParkingCharge(int parkingHours) {
        // charge per after 1 hour : 10$
        if(parkingHours < 1){
            return 5;
        }
        return parkingHours * 10;
    }
}
