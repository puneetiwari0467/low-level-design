package com.walmart.practice.webApplication.ParkingLot;

public class ExitGate {
	
	Ticket ticket;
	
	CostComputationFactory costComputationFactory;
	
	ParkingSpotManager parkingSpotManager;
	
	PaymentService paymentService;
	
	ExitGate(Ticket ticket,ParkingSpotManager parkingSpotManager){
		this.ticket=ticket;
		this.parkingSpotManager=parkingSpotManager;
		this.costComputationFactory=new CostComputationFactory();
		this.paymentService=new PaymentService();
	}
	
	public Integer calculatePrice(Ticket ticket,Vehicle vehicle) {
		CostComputation costComputation= costComputationFactory.getComputeCost(vehicle);
		return costComputation.computePrice(ticket, vehicle);
	}
	
	public boolean makePayment(int price){
		if(paymentService.processPayment(price)) {
			//if this is success 
			return true;
		}
		
		return false;
	}
	
	void removeVehicle(Ticket ticket){
		parkingSpotManager.removeVehicle(ticket);
	}
	
	
}
