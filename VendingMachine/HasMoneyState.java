package com.walmart.practice.webApplication.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class HasMoneyState implements State{

	@Override
	public void clickOnInsertCoinButton(VendingMachine vm) throws Exception {
		throw new Exception("Operation not allowed");
	}

	@Override
	public void insertCoin(VendingMachine vm, Coin coin) {
		vm.getCoinList().add(coin);
	}

	@Override
	public void selectProductButton(VendingMachine vm) {
		vm.setState(new SelectProductState());
	}

	@Override
	public void chooseProduct(VendingMachine vm, String itemNumber) throws Exception {
		throw new Exception("Operation not allowed");
	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine vm) throws Exception {
		List<Coin>ls=new ArrayList<>();
		for(Coin x:vm.coinList) {
			ls.add(x);
		}
		vm.setState(new IdleState());
		return ls;
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
		throw new Exception("Operation not allowed");	
	}

}
