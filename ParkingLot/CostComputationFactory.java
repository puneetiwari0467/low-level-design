package com.walmart.practice.webApplication.ParkingLot;

public class CostComputationFactory {
	
	public CostComputation getComputeCost(Vehicle vehicle) {
		
		switch(vehicle.vehicleType) {
			case TWO_WHEELER:
				return new TwoWheelerCostComputation(new HourlyPricingStrategy());
			case FOUR_WHEELER:
				return new FourWheelerCostComputation(new MinuteWisePricingStrategy());
			default:
				return new TwoWheelerCostComputation(new HourlyPricingStrategy());
		}
		
	}
	
}
