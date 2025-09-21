package com.walmart.practice.webApplication.MovieBookingSystem;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Booking {
	Show show;
	List<Seat>seats;
	PaymentService paymentService;
	
	public Booking() {
		this.paymentService=new PaymentService();
	}
	

}
