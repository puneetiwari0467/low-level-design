package com.walmart.practice.webApplication.ParkingLot;

import java.util.Arrays;

public class NearToLift implements ParkingStrategy{


	@Override
	public ParkingFloor findParkingSpace(Vehicle vehicle,ParkingSpotManager parkingManager) {
		//let lift is close to even number parking spots
		
		for(ParkingFloor floor:parkingManager.parkingLocations) {
			for(ParkingSpot spot: floor.parkingSpot) {
				if(spot.isOccupied==false && VehicleType.TWO_WHEELER==vehicle.getVehicleType()) {
					return new ParkingFloor(floor.floorNumber,Arrays.asList(spot));
				}
			}
		}
		return null;
	}
	

}
