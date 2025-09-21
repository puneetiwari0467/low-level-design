package com.walmart.practice.webApplication.HotelBookingSystem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {
	Integer id;
	RoomType roomType;
	Double price;
	Status status;
	
	public Room(RoomType roomType,Double price,Status status) {
		this.roomType=roomType;
		this.price=price;
		this.status=status;
	}
}
