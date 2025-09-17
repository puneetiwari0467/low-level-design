package com.walmart.practice.webApplication.ParkingLot;

import java.util.Arrays;

public class NearToExitStrategy implements ParkingStrategy{


	@Override
	public ParkingFloor findParkingSpace(Vehicle vehicle,ParkingSpotManager parkingManager) {
		// TODO Auto-generated method stub
		
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
