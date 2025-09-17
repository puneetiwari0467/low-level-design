package com.walmart.practice.webApplication.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManager {
	List<ParkingFloor>parkingLocations=new ArrayList<>();
	
	
	public ParkingSpotManager() {
		parkingLocations=new ArrayList<>();
	}
	
	ParkingFloor findParkingSpot(Vehicle vehicle,ParkingStrategy parkingStrategy){
		return parkingStrategy.findParkingSpace(vehicle,this);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	ParkingFloor parkVehicle(Vehicle vehicle,ParkingFloor parkingFloor) {
		
		if(parkingFloor!=null) {
			for (ParkingFloor floor : parkingLocations) {
		        // Check if this is the same floor (better: compare by floorId)
		        if (floor.getFloorNumber().equals(parkingFloor.getFloorNumber())) {
		            
		            // Iterate over all spots in that floor
		            for (ParkingSpot spot : floor.getParkingSpot()) {
		                // Check if this is the same spot (better: compare by spotId)
		                if (spot.getId().equals(parkingFloor.getParkingSpot().get(0).getId() ) && !spot.isOccupied()) {
		                    spot.setOccupied(true);
		                    spot.setVehicle(vehicle);
		                    return floor; // return the updated floor
		                }
		            }
		        }
		    }
			return null;
		}
		return null;
		
	}
	
	void removeVehicle(Ticket ticket) {
		ticket.parkingFloor.parkingSpot.get(0).isOccupied=false;
		ticket.parkingFloor.parkingSpot.get(0).vehicle=null;
	}
	
	void addParkingSpot(int floorNumber,List<ParkingSpot>parkingSpots){
		for(ParkingFloor parkingFloor:parkingLocations) {
			if(parkingFloor.floorNumber==floorNumber) {
				parkingFloor.getParkingSpot().addAll(parkingSpots);
			}
		}
	}
	
	void addParkingFloor(int floorNumber,List<ParkingSpot>parkingSpots){
		ParkingFloor floor=new ParkingFloor(floorNumber,parkingSpots);
		parkingLocations.add(floor);
	}
	
	void removeParkingSpot(int floorNumber,List<ParkingSpot>parkingSpots){
		for (ParkingFloor parkingFloor : parkingLocations) {
	        if (parkingFloor.floorNumber == floorNumber) {
	            parkingFloor.getParkingSpot().removeAll(parkingSpots);
	            break;
	        }
	    }
	}
	
	void removeParkingFloor(int floorNumber,List<ParkingSpot>parkingSpots){
		parkingLocations.removeIf(parkingFloor -> parkingFloor.floorNumber == floorNumber);
	}
}
