package ParkingLot.Fatories;

import ParkingLot.Models.LotAssignmentStrategies;
import ParkingLot.Stratergies.ParkingSlotStratergy;
import ParkingLot.Stratergies.RandomParkingSlotStratergy;

public class ParkingLotAssignmentStrategyFactory {
    public ParkingSlotStratergy getStrategy(LotAssignmentStrategies strategy){
        return switch (strategy){
            case NEAREST_ASSIGNMENT_STRATEGY -> new RandomParkingSlotStratergy();
            case RANDOM_ASSIGNMENT_STRATEGY -> new RandomParkingSlotStratergy();
            default -> throw new IllegalArgumentException("Invalid strategy");
        };
    }
}
