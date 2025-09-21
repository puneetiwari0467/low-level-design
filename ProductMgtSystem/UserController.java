package com.walmart.practice.webApplication.ProductMgtSystem;

import java.util.ArrayList;
import java.util.List;

public class UserController {
	List<User>users;
	
	public UserController() {
		this.users=new ArrayList<>();
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void removeUser(User user){
		users.remove(user);
	}
}	
