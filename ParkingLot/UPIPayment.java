package com.walmart.practice.webApplication.ParkingLot;

public class UPIPayment implements PaymentStrategy{

	@Override
	public boolean makePayment(double price) {
		System.out.println("Payment has been made via UPI :"+price);
		return true;
	}

}
