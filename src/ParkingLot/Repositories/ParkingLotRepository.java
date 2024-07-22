package ParkingLot.Repositories;

import java.util.HashSet;
import java.util.Optional;

import ParkingLot.Models.ParkingLot;

public class ParkingLotRepository {
    HashSet<ParkingLot> parkingLots;

    public Optional<ParkingLot> getParkingLotFromGateId(Long GateId){
        return Optional.empty();
    }
}
