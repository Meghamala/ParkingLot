public class Slot {
    private int slotNumber;
    private Vehicle parkedVehicle;
    private boolean isEmpty;

    public Slot(int slotNumber){
        this.slotNumber = slotNumber;
        isEmpty = true;
    }

    public int getSlotNumber(){
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber){
        this.slotNumber = slotNumber;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public void vacateSlot(){
        parkedVehicle = null;
        this.isEmpty = true;
    }

    public void occupySlot(Vehicle parkedVehicle){
        this.parkedVehicle = parkedVehicle;
        this.isEmpty = false;
    }

    public Vehicle getParkedVehicle(){
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle){
        this.parkedVehicle = parkedVehicle;
    }

}
