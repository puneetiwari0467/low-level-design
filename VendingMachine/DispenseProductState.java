package com.walmart.practice.webApplication.VendingMachine;

import java.util.List;

public class DispenseProductState implements State{

	@Override
	public void clickOnInsertCoinButton(VendingMachine vm) throws Exception {
		throw new Exception("Operation not allowed");
		
	}

	@Override
	public void insertCoin(VendingMachine vm, Coin coin) throws Exception {
		throw new Exception("Operation not allowed");
		
	}

	@Override
	public void selectProductButton(VendingMachine vm) throws Exception {
		throw new Exception("Operation not allowed");
	}

	@Override
	public void chooseProduct(VendingMachine vm, String itemNumber) throws Exception {
		throw new Exception("Operation not allowed");
		
	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine vm) throws Exception {
		
		throw new Exception("Operation not allowed");
	}

	@Override
	public Integer getChange(Integer refundExtraMoney) throws Exception {
		throw new Exception("Operation not allowed");
		
	}

	@Override
	public Item dispenseProduct(VendingMachine vm, String itemNumber) throws Exception {
		Item item=vm.getInventory().getItem(itemNumber);
		updateInventory(vm, item, itemNumber);
		return item;
		
	}

	@Override
	public void updateInventory(VendingMachine vm,Item item,String codeNumber) throws Exception {
		vm.getInventory().updateSoldItem(codeNumber);
	}
	
}
