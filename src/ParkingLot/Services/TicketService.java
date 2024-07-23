package ParkingLot.Services;

import ParkingLot.Exceptions.*;
import ParkingLot.Fatories.ParkingLotAssignmentStrategyFactory;
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
    TicketRepository ticketRepository;

    TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository= gateRepository;
        this.vehicleRepository= vehicleRepository;
        this.parkingLotRepository= parkingLotRepository;
        this.ticketRepository= ticketRepository;
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
        ParkingLotAssignmentStrategyFactory parkingLotAssignmentStrategyFactory = new ParkingLotAssignmentStrategyFactory();
        ParkingSlotStratergy strategy= parkingLotAssignmentStrategyFactory.getStrategy(lotStrategy);

        Optional<ParkingSpot> parkingSpotOptional= strategy.getParkingSpot(gate.get(),vehicletype);
        parkingSpotOptional.orElseThrow(()-> new ParkingLotNotFoundException("No parking spot found"));

        Ticket ticket = new Ticket();
        ticket.setGate(gate.get());
        ticket.setEntryTime(new Date());
        ticket.setVehicle(savedVehicle);
        ticket.setParkingSpot(parkingSpotOptional.get());

        return ticketRepository.addTicket(ticket);
    }
}
