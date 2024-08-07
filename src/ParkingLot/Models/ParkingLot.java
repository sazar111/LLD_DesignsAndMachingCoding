package ParkingLot.Models;

import java.util.List;

public class ParkingLot extends BaseModel{
    List<Gate> gates;
    List<ParkingFloor> parkingFloors;
    LotAssignmentStrategies lotAssignmentStrategies;

    public LotAssignmentStrategies getLotAssignmentStratergy() {
        return lotAssignmentStrategies;
    }

    public void setLotAssignmentStratergy(LotAssignmentStrategies lotAssignmentStrategies) {
        this.lotAssignmentStrategies = lotAssignmentStrategies;
    }



    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}
