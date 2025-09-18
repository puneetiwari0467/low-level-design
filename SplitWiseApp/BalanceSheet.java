package com.walmart.practice.webApplication.SplitWiseApp;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceSheet {
	Double totalPayment;
	Double totalOwes;
	Double totalGetBack;
	Map<User,Balance>friendVsBalance;
	
	public BalanceSheet() {
		totalPayment=0.0;
		totalOwes=0.0;
		totalGetBack=0.0;
		friendVsBalance=new HashMap<User, Balance>();
	}
	
}
