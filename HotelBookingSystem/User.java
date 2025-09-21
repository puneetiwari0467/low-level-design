package com.walmart.practice.webApplication.HotelBookingSystem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	Integer id;
	String name;
	String email;
	String phone;
	String password;
	
	public User(String name,String email) {
		this.name=name;
		this.email=email;
	}
}
