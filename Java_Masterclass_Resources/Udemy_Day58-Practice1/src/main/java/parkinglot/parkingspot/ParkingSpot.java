package parkinglot.parkingspot;

import parkinglot.vehicle.Vehicle;

// Abstract base class for Parking Spot
public abstract class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isOccupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupySpot() {
        isOccupied = true;
    }

    public void freeSpot() {
        isOccupied = false;
    }

    // Abstract method to determine if a vehicle can park in this spot
    public abstract boolean canFitVehicle(Vehicle vehicle);
}