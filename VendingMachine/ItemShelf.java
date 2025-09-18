package com.walmart.practice.webApplication.VendingMachine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemShelf {
	Item item;
	String code;
	boolean soldOut;
}
