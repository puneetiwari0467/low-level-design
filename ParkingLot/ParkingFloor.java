package com.walmart.practice.webApplication.ParkingLot;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingFloor {
	Integer floorNumber;
	public List<ParkingSpot>parkingSpot;
	
	public ParkingFloor(int floorNumber,List<ParkingSpot>parkingSpots) {
		this.floorNumber=floorNumber;
		this.parkingSpot=new ArrayList<>(parkingSpots);
	}
}
