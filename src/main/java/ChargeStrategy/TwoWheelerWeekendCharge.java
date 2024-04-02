package ChargeStrategy;

public class TwoWheelerWeekendCharge implements ParkingChargeStrategy{

    @Override
    public double getParkingCharge(int parkingHours) {
        if(parkingHours < 1){
            return 7;
        }
        return parkingHours * 15;
    }
}
