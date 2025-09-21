package com.walmart.practice.webApplication.MovieBookingSystem;

public class CashPaymentStrategy implements PaymentStrategy{

	@Override
	public void processPayment(double amount) {
		
		System.out.println("payment done via cash "+amount);
	}

}
