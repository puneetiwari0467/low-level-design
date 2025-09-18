package com.walmart.practice.webApplication.SplitWiseApp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
	Integer userId;
	String name;
	BalanceSheet balanceSheet;
	
	public User(Integer userId,String name) {
		this.userId=userId;
		this.name=name;
		this.balanceSheet=new BalanceSheet();
	}
}
