package com.walmart.practice.webApplication.ParkingLot;

public class CashPayment implements PaymentStrategy{

	@Override
	public boolean makePayment(double price) {
		System.out.println("Payment has been made via Cash :"+price);
		return true;
	}
	

}
