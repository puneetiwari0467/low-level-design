package com.walmart.practice.webApplication.ParkingLot;

public interface ParkingStrategy {

	ParkingFloor findParkingSpace(Vehicle vehicle,ParkingSpotManager parkingManager);
}
