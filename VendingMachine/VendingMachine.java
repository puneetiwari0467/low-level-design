package com.walmart.practice.webApplication.VendingMachine;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendingMachine {
	State state;
	Inventory inventory;
	List<Coin>coinList;
	
	public VendingMachine() {
		state=new IdleState();
		this.coinList=new ArrayList<>();
	}
}
