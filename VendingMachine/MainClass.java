package com.walmart.practice.webApplication.VendingMachine;

public class MainClass {
	
	public static void main(String[]args) throws Exception {
		
		//initialize this vending machine 
		VendingMachine vm=new VendingMachine();
		Inventory inv=new Inventory(10);
		fillUpInventory(inv);
		vm.setInventory(inv);
		
		vm.getInventory().displayInventory();
		//intially in idle state 
		State vendingState=vm.getState();
		vendingState.clickOnInsertCoinButton(vm);
		
		//now vending machine came in hasMoney state
		vendingState=vm.getState();
		vendingState.insertCoin(vm, Coin.NICKLE);
		vendingState.insertCoin(vm, Coin.GOLD);
		//vendingState.refundFullMoney(vm);
		vendingState.selectProductButton(vm);
		
		//now vending machine come to select product state
		vendingState=vm.getState();
		vendingState.chooseProduct(vm, "103");
		//vendingState.refundFullMoney(vm);
		
		//dispense Product
		vendingState=vm.getState();
		vendingState.dispenseProduct(vm, "103");
		
		vm.getInventory().displayInventory();
	}
	
	private static void fillUpInventory(Inventory inv) throws Exception{
		Item item;
		for(int i=0;i<10;i++) {
			if(i<=3) {
				item=new Item(ItemType.COKE,10);
				inv.addItem(item, inv.getInventory()[i].getCode());
			}else if(i<=6) {
				item=new Item(ItemType.PEPSI,20);
				inv.addItem(item, inv.getInventory()[i].getCode());
			}else if(i<=8) {
				item=new Item(ItemType.JUICE,30);
				inv.addItem(item, inv.getInventory()[i].getCode());
			}else {
				item=new Item(ItemType.SODA,40);
				inv.addItem(item, inv.getInventory()[i].getCode());
			}
			
		}
	}
}
