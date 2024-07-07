package ParkingLot.Models;

public class ParkingSpot {
    ParkingSpotStatus parkingSpotStatus;
    VehicleType supportedVehicleTypes;

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public VehicleType getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(VehicleType supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }
}
