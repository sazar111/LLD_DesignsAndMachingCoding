package ParkingLot.Services;

import ParkingLot.Exceptions.*;
import ParkingLot.Models.*;
import ParkingLot.Repositories.*;
import ParkingLot.Repositories.VehicleRepository;
import ParkingLot.Stratergies.ParkingSlotStratergy;


import java.util.Date;
import java.util.Optional;

public class TicketService {
    GateRepository gateRepository;
    VehicleRepository vehicleRepository;
    ParkingLotRepository parkingLotRepository;

    TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository) {
        this.gateRepository= gateRepository;
        this.vehicleRepository= vehicleRepository;
        this.parkingLotRepository= parkingLotRepository;
    }

    public Ticket issueTicket(long gateId, String ownerName, String vehicleNumber, VehicleType vehicletype) {

        Optional<Gate> gate= gateRepository.getGateFromId(gateId);
        gate.orElseThrow(()-> new GateNotFoundException("No gate"));
        Vehicle savedVehicle=null;

        Optional<Vehicle> vehicle= vehicleRepository.getVehicleFromVehicleNumber(vehicleNumber);
        if(vehicle.isEmpty()){
            Vehicle vehicleObj = new Vehicle();
            vehicleObj.setVehicleType(vehicletype);
            vehicleObj.setLicensePlate(vehicleNumber);
            vehicleObj.setOwnerName(ownerName);
            savedVehicle= vehicleRepository.save(vehicleObj);
        }else{
            savedVehicle= vehicle.get();
        }

        Optional<ParkingLot> parkinglot= parkingLotRepository.getParkingLotFromGateId(gateId);
        if(parkinglot.isEmpty()){
            throw new ParkingLotNotFoundException("Parking lot not found");
        }
        LotAssignmentStrategies lotStrategy= parkinglot.get().getLotAssignmentStratergy();

        Ticket ticket = new Ticket();
        ticket.setGate(gate.get());
        ticket.setEntryTime(new Date());
        ticket.setVehicle(savedVehicle);
        ticket.setParkingSpot();
        return ticket;
    }
}
