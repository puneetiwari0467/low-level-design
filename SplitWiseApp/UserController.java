package com.walmart.practice.webApplication.SplitWiseApp;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserController {
	List<User>users;
	
	public UserController() {
		this.users=new ArrayList<>();
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void removeUser(User user) {
		users.remove(user);
	}
	
	public void updateUser(User user) {
		//update user
	}
}
