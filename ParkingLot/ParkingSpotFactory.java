package com.walmart.practice.webApplication.ParkingLot;

public class ParkingSpotFactory {
	
	ParkingSpotManager getParkingSpotManager(Vehicle vehicle) {
		
		switch(vehicle.vehicleType) {
		case TWO_WHEELER:
			return new TwoWheelerManager(null);
		case FOUR_WHEELER:
			return new FourWheelerManager(null);
		default:
			return null;
		}
	}

}
