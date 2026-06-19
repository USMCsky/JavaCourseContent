package parkinglot.parkingspot;

import parkinglot.vehicle.Car;
import parkinglot.vehicle.HandicappedVehicle;
import parkinglot.vehicle.Motorcycle;
import parkinglot.vehicle.Vehicle;

// Concrete subclass for Compact Spot
public class CompactSpot extends ParkingSpot {
    public CompactSpot(int spotNumber) {
        super(spotNumber);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle instanceof Motorcycle;
    }
}