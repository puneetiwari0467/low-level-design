package com.walmart.practice.webApplication.VendingMachine;

public enum Coin {
	DIME(10),NICKLE(50),QUARTER(75),GOLD(100);

	int val;
	Coin(int val) {
		this.val=val;
	}

	
}
