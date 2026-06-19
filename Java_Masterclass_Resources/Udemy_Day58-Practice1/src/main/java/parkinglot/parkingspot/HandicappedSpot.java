package parkinglot.parkingspot;

import parkinglot.vehicle.Vehicle;

// Concrete subclass for Handicapped Spot
public class HandicappedSpot extends ParkingSpot {
    public HandicappedSpot(int spotNumber) {
        super(spotNumber);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return true; // Any vehicle can fit in a handicapped spot
    }
}