package com.walmart.practice.webApplication.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class SelectProductState implements State{

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
		Integer paidByUser=0;
		for(Coin x:vm.coinList) {
			paidByUser+=x.val;
		}
		Item item=vm.getInventory().getItem(itemNumber);
		if(paidByUser>=item.getPrice()) {
			if(paidByUser > item.getPrice()) {
                getChange(paidByUser-item.getPrice());
            }
			vm.setState(new DispenseProductState());
		}else {
			refundFullMoney(vm);
			vm.setState(new IdleState());
		}
	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine vm) {
		List<Coin>ls=new ArrayList<>();
		for(Coin x:vm.coinList) {
			ls.add(x);
		}
		vm.setState(new IdleState());
		return ls;
	}

	@Override
	public Integer getChange(Integer returnExtraMoney) {
		System.out.println("Extra Amount "+returnExtraMoney+" returned on cash tray please collect");
		return returnExtraMoney;
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
