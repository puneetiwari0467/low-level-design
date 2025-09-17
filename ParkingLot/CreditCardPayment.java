package com.walmart.practice.webApplication.ParkingLot;

public class CreditCardPayment implements PaymentStrategy{

	@Override
	public boolean makePayment(double price) {
		System.out.println("Payment has been made via Credit Card :"+price);
		return true;
	}

}
