package com.walmart.practice.webApplication.SplitWiseApp;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Expense {
	Integer expenseId;
	String desc;
	double amount;
	User paidBy;
	SplitType splitType;
	List<Split>split;
	
	
}
