package ParkingLot.Repositories;

import ParkingLot.Models.Gate;

import java.util.HashMap;
import java.util.Optional;

public class GateRepository {
    HashMap<Long,Gate> gateRepo= new HashMap<Long, Gate>();
    Long lastGateId=0L;

    public Optional<Gate> getGateFromId(long gateId){
        if(gateRepo.containsKey(gateId)){
            return Optional.of(gateRepo.get(gateId));
        }
        return Optional.empty();
    }

    public Gate save(Gate gate){
        if(gate.getId() == null){
            lastGateId++;
            gate.setId(lastGateId);
            gateRepo.put(lastGateId,gate);
            return gateRepo.get(lastGateId);
        }
        gateRepo.put(gate.getId(),gate);
        return gateRepo.get(gate.getId());
    }
}
