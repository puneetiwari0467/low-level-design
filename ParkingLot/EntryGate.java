package com.walmart.practice.webApplication.ParkingLot;

import java.time.LocalDateTime;

public class EntryGate {
	ParkingSpotFactory parkingSpotFactory;
	ParkingSpotManager parkingSpotManager;
	
	public EntryGate(ParkingSpotManager parkingSpotManager) {
		// TODO Auto-generated constructor stub
		this.parkingSpotManager=parkingSpotManager;
	}
	
	ParkingFloor bookParkingSpot(Vehicle vehicle,ParkingStrategy parkingStrategy) {
		ParkingFloor parkingFloor=parkingSpotManager.findParkingSpot(vehicle,parkingStrategy);
		return parkingSpotManager.parkVehicle(vehicle,parkingFloor);
	}

	Ticket generateTicket(Vehicle vehicle,ParkingStrategy parkingStrategy){
		ParkingFloor parkingFloor=bookParkingSpot(vehicle,parkingStrategy);
		if(parkingFloor==null) {
			return null;
		}
		Ticket ticket=new Ticket();
		ticket.entryTime=LocalDateTime.now();
		ticket.parkingFloor=parkingFloor;
		return ticket;
	}
}
