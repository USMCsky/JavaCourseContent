package parkinglot;

import parkinglot.parkingspot.CompactSpot;
import parkinglot.parkingspot.HandicappedSpot;
import parkinglot.parkingspot.RegularSpot;
import parkinglot.vehicle.Car;
import parkinglot.vehicle.HandicappedVehicle;
import parkinglot.vehicle.Motorcycle;
import parkinglot.vehicle.Vehicle;

// Main class to demonstrate the parking lot system
public class ParkingLotSystem {

    public static void main(String[] args) {
        // Initialize parking lot and add various types of spots
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addSpot(new RegularSpot(1));
        parkingLot.addSpot(new CompactSpot(2));
        parkingLot.addSpot(new HandicappedSpot(3));

        // Create various vehicles
        Vehicle car = new Car("CAR123");
        Vehicle motorcycle = new Motorcycle("MOTO456");
        Vehicle handicappedVehicle = new HandicappedVehicle("HAND789");

        // Park vehicles
        parkingLot.parkVehicle(car);              // Expected: Car parks in a Regular or Handicapped spot
        parkingLot.parkVehicle(motorcycle);       // Expected: Motorcycle parks in a Compact spot
        parkingLot.parkVehicle(handicappedVehicle); // Expected: Handicapped vehicle parks in any spot

        // Display available spots
        parkingLot.displayAvailableSpots();

        // Remove a vehicle
        parkingLot.removeVehicle(1); // Free up spot 1

        // Display available spots again
        parkingLot.displayAvailableSpots();
    }
}
