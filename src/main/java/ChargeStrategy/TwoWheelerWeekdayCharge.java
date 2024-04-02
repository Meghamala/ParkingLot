package ChargeStrategy;

public class TwoWheelerWeekdayCharge implements ParkingChargeStrategy{


    @Override
    public double getParkingCharge(int parkingHours) {
        if(parkingHours < 1){
            return 3;
        }
        return parkingHours * 5;
    }
}
