package parkinglot;

import parkinglot.parkingspot.ParkingSpot;
import parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

// Class representing the Parking Lot
class ParkingLot {
    private List<ParkingSpot> spots;

    public ParkingLot() {
        this.spots = new ArrayList<>();
    }

    // Method to add a parking spot to the lot
    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    // Method to park a vehicle in the lot
    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && spot.canFitVehicle(vehicle)) {
                spot.occupySpot();
                System.out.println("Vehicle with license plate " + vehicle.getLicensePlate() + " parked in spot " + spot.getSpotNumber() +" of type "+ spot.getClass().getSimpleName());
                return true;
            }
        }
        System.out.println("No available spot for vehicle with license plate " + vehicle.getLicensePlate());
        return false;
    }

    // Method to remove a vehicle from a spot
    public void removeVehicle(int spotNumber) {
        for (ParkingSpot spot : spots) {
            if (spot.getSpotNumber() == spotNumber && spot.isOccupied()) {
                spot.freeSpot();
                System.out.println("Spot " + spotNumber + " of type "+ spot.getClass().getSimpleName() + " is now free.");
                return;
            }
        }
        System.out.println("Spot " + spotNumber + " is already free or does not exist.");
    }

    // Method to check available spots
    public void displayAvailableSpots() {
        System.out.println("Available spots:");
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                System.out.println("Spot " + spot.getSpotNumber() + " - " + spot.getClass().getSimpleName());
            }
        }
    }
}
