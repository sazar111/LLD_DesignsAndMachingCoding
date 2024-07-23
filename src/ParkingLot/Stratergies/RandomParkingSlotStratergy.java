package ParkingLot.Stratergies;

import ParkingLot.Models.Gate;
import ParkingLot.Models.ParkingSpot;
import ParkingLot.Models.VehicleType;

import java.util.Optional;

public class RandomParkingSlotStratergy implements ParkingSlotStratergy {

    @Override
    public Optional<ParkingSpot> getParkingSpot(Gate gate, VehicleType vehicleType) {
        return null;
    }
}
