package com.walmart.practice.webApplication.VendingMachine;

import java.util.List;

public class IdleState implements State{

	@Override
	public void clickOnInsertCoinButton(VendingMachine vm) {
		vm.setState(new HasMoneyState());
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
	public Integer getChange(Integer returnExtraMoney) throws Exception {
		throw new Exception("Operation not allowed");
	}

	@Override
	public Item dispenseProduct(VendingMachine vm, String itemNumber) throws Exception {
		throw new Exception("Operation not allowed");
	}

	@Override
	public void updateInventory(VendingMachine vm,Item item,String codeNumber) throws Exception {
		vm.getInventory().addItem(item, codeNumber);
	}

}
