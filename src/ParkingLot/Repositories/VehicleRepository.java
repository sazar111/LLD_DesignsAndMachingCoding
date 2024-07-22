package ParkingLot.Repositories;

import ParkingLot.Models.Vehicle;

import java.util.HashMap;
import java.util.Optional;

public class VehicleRepository {
    HashMap<String, Vehicle> vehicles;
    Long lastId=0L;

    public Optional<Vehicle> getVehicleFromVehicleNumber(String vehicleNumber){
        if(vehicles.containsKey(vehicleNumber)){
            return Optional.of(vehicles.get(vehicleNumber));
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle){
        if(vehicle.getId()==null){
            lastId++;
            vehicle.setId(lastId);
            vehicles.put(vehicle.getLicensePlate(),vehicle);
            return vehicles.get(vehicle.getLicensePlate());
        }
        vehicles.put(vehicle.getLicensePlate(),vehicle);
        return vehicles.get(vehicle.getLicensePlate());
    }
}
