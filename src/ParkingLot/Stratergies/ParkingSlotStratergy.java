package ParkingLot.Stratergies;

import ParkingLot.Models.Gate;
import ParkingLot.Models.ParkingSpot;
import ParkingLot.Models.VehicleType;

import java.util.Optional;

public interface ParkingSlotStratergy {
    Optional<ParkingSpot> getParkingSpot(Gate gate, VehicleType vehicleType);
}
