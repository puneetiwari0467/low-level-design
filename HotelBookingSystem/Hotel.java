package com.walmart.practice.webApplication.HotelBookingSystem;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hotel {
	Integer id;
	String name;
	Address address;
	List<Room>rooms;
	Integer rating;
	List<Review>comments;
	
	public Hotel(String name,Address address,List<Room>rooms) {
		this.name=name;
		this.address=address;
		this.rooms=rooms;
	}
}
