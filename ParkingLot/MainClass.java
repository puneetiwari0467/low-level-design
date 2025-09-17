 package com.walmart.practice.webApplication.ParkingLot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
	public static void main(String [] args) {
		
		Vehicle vehicle=new Vehicle(VehicleType.TWO_WHEELER,"34566");
		ParkingSpotManager parkingSpotManager=new ParkingSpotManager();
		initializeParkingLot(parkingSpotManager);
		
		//ParkingSpotFactory parkingSpotFactory=new ParkingSpotFactory();
		//parkingSpotFactory.getParkingSpotManager(vehicle);
		
		EntryGate entryGate=new EntryGate(parkingSpotManager);
		Ticket ticket=entryGate.generateTicket(vehicle,new NearToExitStrategy());
		
		
		ExitGate exitGate=new ExitGate(ticket,parkingSpotManager);
		Integer price=exitGate.calculatePrice(ticket, vehicle);
		
		exitGate.makePayment(price);
		exitGate.removeVehicle(ticket);
	}
	
	public static void initializeParkingLot(ParkingSpotManager parkingSpotManager) {
		
		//Adding ParkingFloors
		ParkingSpot ps1=new TwoWheelerParkingSpot(1,false,null,340);
		ParkingSpot ps2=new TwoWheelerParkingSpot(2,false,null,140);
		ParkingSpot ps3=new FourWheelerParkingSpot(3,false,null,540);
		ParkingSpot ps4=new FourWheelerParkingSpot(4,false,null,740);
		parkingSpotManager.addParkingFloor(1,Arrays.asList(ps1,ps2,ps3,ps4));
		
		ParkingSpot ps11=new TwoWheelerParkingSpot(1,false,null,340);
		ParkingSpot ps12=new TwoWheelerParkingSpot(3,false,null,140);
		ParkingSpot ps13=new FourWheelerParkingSpot(4,false,null,540);
		ParkingSpot ps14=new FourWheelerParkingSpot(2,false,null,740);
		parkingSpotManager.addParkingFloor(2,Arrays.asList(ps11,ps12,ps13,ps14));
		
		ParkingSpot ps21=new TwoWheelerParkingSpot(1,false,null,340);
		ParkingSpot ps22=new TwoWheelerParkingSpot(2,false,null,140);
		ParkingSpot ps23=new FourWheelerParkingSpot(3,false,null,540);
		ParkingSpot ps24=new FourWheelerParkingSpot(4,false,null,740);
		parkingSpotManager.addParkingFloor(3,Arrays.asList(ps21,ps22,ps23,ps24));
		
		//Adding parkingSpot
		ParkingSpot ps25=new FourWheelerParkingSpot(4,false,null,740);
		List<ParkingSpot> newSpots = new ArrayList<>();
		newSpots.add(ps25);
		parkingSpotManager.addParkingSpot(3, newSpots);
		
	}
}
