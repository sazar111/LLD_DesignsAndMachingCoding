package ParkingLot.Exceptions;

public class GateNotFoundException extends RuntimeException  {
    public GateNotFoundException(String message) {
        super(message);
    }
}
