package com.walmart.practice.webApplication.ParkingLot;

public class CostComputation {
	PricingStrategy pricingStrategy;
	
	public CostComputation(PricingStrategy pricingStrategy) {
		this.pricingStrategy=pricingStrategy;
	}
	
	Integer computePrice(Ticket ticket,Vehicle vehicle){
		return pricingStrategy.getPrice(ticket);
	}
	
}
