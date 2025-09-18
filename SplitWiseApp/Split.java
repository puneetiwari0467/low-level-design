package com.walmart.practice.webApplication.SplitWiseApp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Split {

	User user;
	Double amount;
	Double percentage;
	
	public Split(User user, Double amount, Double percentage) {
		super();
		this.user = user;
		this.amount = amount;
		this.percentage = percentage;
	}
}
