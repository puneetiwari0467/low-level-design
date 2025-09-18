package com.walmart.practice.webApplication.VendingMachine;

import java.util.List;

public interface State {
	void clickOnInsertCoinButton(VendingMachine vm) throws Exception;
	void insertCoin(VendingMachine vm,Coin coin) throws Exception;
	void selectProductButton(VendingMachine vm) throws Exception;
	void chooseProduct(VendingMachine vm,String itemNumber) throws Exception;
	List<Coin> refundFullMoney(VendingMachine vm) throws Exception;
	Integer getChange(Integer returnExtraMoney) throws Exception;
	Item dispenseProduct(VendingMachine vm,String itemNumber) throws Exception;
	void updateInventory(VendingMachine vm,Item item,String codeNumber) throws Exception;
}
