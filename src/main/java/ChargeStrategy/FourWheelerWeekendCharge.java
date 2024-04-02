package ChargeStrategy;

public class FourWheelerWeekendCharge implements ParkingChargeStrategy{


    @Override
    public double getParkingCharge(int parkingHours) {
        if(parkingHours < 1){
            return 10;
        }
        return parkingHours * 20;
    }
}
