package com.walmart.practice.webApplication.ParkingLot;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ParkingSpot {
	
	Integer id;
	boolean isOccupied;
	Vehicle vehicle;
	Integer price;
	
	
	public abstract void parkVehicle(Vehicle vehicle);
	
	public abstract void removeVehicle(Vehicle vehicle);
	
	
	
}
