import java.util.Date;

public class Ticket {
    private int slotNumber;
    private String licensePlate;
    private Date date;
    private VehicleType vehicleType;

    public Ticket(int slotNumber, String licensePlate, Date date, VehicleType vehicleType){
        this.slotNumber = slotNumber;
        this.licensePlate = licensePlate;
        this.date = date;
        this.vehicleType = vehicleType;
    }

    public int getSlotNumber(){
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber){
        this.slotNumber = slotNumber;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public void setLicencePlate(String licensePlate){
        this.licensePlate = licensePlate;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString(){
        return "Ticket [slotNumber=" + slotNumber +", licensePlate="+ licensePlate +", date="+ date +" , vehicleType="+ vehicleType+"]";
    }
}
