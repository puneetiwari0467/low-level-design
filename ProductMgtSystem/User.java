package com.walmart.practice.webApplication.ProductMgtSystem;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	Integer userId;
	String name;
	String email;
	String password;
	Cart cart;
	List<Integer>orderIds;
	
	public User(Integer userId,String name) {
		this.userId=userId;
		this.name=name; 
		this.cart=new Cart();
		orderIds=new ArrayList<>();
	}
}
