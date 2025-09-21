package com.walmart.practice.webApplication.MovieBookingSystem;

public class Payment {
	PaymentStrategy paymentStrategy;
	
	public Payment(PaymentStrategy paymentStrategy) {
		this.paymentStrategy=paymentStrategy;
	}
	
	void processPayment(double amount){
		paymentStrategy.processPayment(amount);
	}
	
}
