package ParkingLot.Stratergies;

import ParkingLot.Models.Gate;
import ParkingLot.Models.ParkingSpot;
import ParkingLot.Models.VehicleType;

public interface ParkingSlotStratergy {
    ParkingSpot getParkingSpot(Gate gate,VehicleType vehicleType);
}
