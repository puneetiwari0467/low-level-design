package com.walmart.practice.webApplication.ParkingLot;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy extends PricingStrategy{

	@Override
	Integer getPrice(Ticket ticket) {
		return (int) Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours()*ticket.parkingFloor.parkingSpot.get(0).getPrice();
	}

}
