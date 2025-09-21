package com.walmart.practice.webApplication.HotelBookingSystem;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserController {
	List<User>users=new ArrayList<>();
	
	void addUser(User user) {
		users.add(user);
	}
	
	void removeUser(User user) {
		users.remove(user);
	}
}
