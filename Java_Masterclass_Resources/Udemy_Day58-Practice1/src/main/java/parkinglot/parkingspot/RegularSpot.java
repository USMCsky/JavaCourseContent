package parkinglot.parkingspot;

import parkinglot.vehicle.Car;
import parkinglot.vehicle.HandicappedVehicle;
import parkinglot.vehicle.Vehicle;

// Concrete subclass for Regular Spot
public class RegularSpot extends ParkingSpot {
    public RegularSpot(int spotNumber) {
        super(spotNumber);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle instanceof Car || vehicle instanceof HandicappedVehicle;
    }
}