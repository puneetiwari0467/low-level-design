package com.walmart.practice.webApplication.MovieBookingSystem;


public class PaymentService {
	
	Payment payment=new Payment(new CashPaymentStrategy());
	
	public void makePayment(double amount) {
		payment.processPayment(amount);
	}
}
