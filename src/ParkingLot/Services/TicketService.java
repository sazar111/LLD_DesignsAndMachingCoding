package ParkingLot.Services;

import ParkingLot.Exceptions.GateNotFoundException;
import ParkingLot.Models.Gate;
import ParkingLot.Models.Ticket;
import ParkingLot.Models.VehicleType;
import ParkingLot.Repositories.GateRepository;

import java.util.Optional;

public class TicketService {
    GateRepository gateRepository;

    TicketService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Ticket issueTicket(long gateId, String ownerName, String vehicleNumber, VehicleType vehicletype) {
        Ticket ticket = new Ticket();
        Optional<Gate> gate= gateRepository.getGateFromId(gateId);
        gate.orElseThrow(()-> new GateNotFoundException("No gate"));

        return ticket;
    }
}
