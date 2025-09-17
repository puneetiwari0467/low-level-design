package com.walmart.practice.webApplication.ParkingLot;

import java.util.Scanner;

public class PaymentService {
	
	Payment payment;
	
	public boolean processPayment(double amount) {
		return choosePaymentMethod(amount);
	}
	
	public boolean choosePaymentMethod(double amount) {
		System.out.println("Total Amount: "+ amount);
		System.out.println("Choose Payment method: ");
		System.out.println("1. Credit Card");
		System.out.println("2. Cash");
		System.out.println("3. UPI");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		
		switch(choice) {
			case 1 :
				payment = new Payment(amount,new CreditCardPayment());
				break;
			case 2 :
				payment = new Payment(amount,new CashPayment());
				break;
			case 3 :
				payment = new Payment(amount,new UPIPayment());
				break;
			default:
				payment = new Payment(amount,new CashPayment());
		}
		return payment.processPayment();
		
	}
}
