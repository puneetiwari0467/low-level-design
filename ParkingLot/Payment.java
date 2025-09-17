package com.walmart.practice.webApplication.ParkingLot;

public class Payment {
	double amount;
	PaymentStrategy paymentStrategy;
	
	Payment(double amount,PaymentStrategy ps){
		this.amount=amount;
		this.paymentStrategy=ps;
	}
	
	boolean  processPayment(){
		if(amount>0) {
			return paymentStrategy.makePayment(amount);
		}else {
			System.out.println("Invalid Payment Amount");
			return false;
		}
	}
}
