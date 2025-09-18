package com.walmart.practice.webApplication.VendingMachine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
	ItemType itemType;
	int price;
	
	
}
