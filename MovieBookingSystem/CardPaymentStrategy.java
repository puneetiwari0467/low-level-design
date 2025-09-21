package com.walmart.practice.webApplication.MovieBookingSystem;

public class CardPaymentStrategy implements PaymentStrategy{
	@Override
	public void processPayment(double amount) {
		System.out.println("payment done via card "+amount);
		
	}
}
