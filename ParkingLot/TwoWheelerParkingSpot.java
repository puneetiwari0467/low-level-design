package com.walmart.practice.webApplication.ParkingLot;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TwoWheelerParkingSpot extends ParkingSpot{
	
	public TwoWheelerParkingSpot(int id, boolean isOccupied, Vehicle vehicle, int price) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.isOccupied=isOccupied;
		this.vehicle=vehicle;
		this.price=price;
	}

	@Override
	public void parkVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		if(isOccupied) {
			throw new IllegalStateException("Spot is already occupied.");
		}
		if(vehicle.vehicleType!=VehicleType.TWO_WHEELER) {
			throw new IllegalStateException("Not possible.");
		}
		this.vehicle=vehicle;
		isOccupied=true;
	}

	@Override
	public void removeVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		if(!isOccupied) {
			throw new IllegalStateException("Not possible");
		}
		this.vehicle=null;
		isOccupied=false;
	}

}
