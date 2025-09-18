package com.walmart.practice.webApplication.VendingMachine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inventory {
	ItemShelf [] inventory;
	
	public Inventory(int size) {
		inventory=new ItemShelf[size];
		initializeInventory();
	}
	
	void displayInventory(){
		for(int i=0;i<inventory.length;i++) {
			if(!inventory[i].isSoldOut()) {
				System.out.println(inventory[i].getItem().itemType+" "+inventory[i].getCode()+" "+inventory[i].getItem().getPrice());
			}
		}
	}
	
	void initializeInventory() {
		String codeNumber="101";
		for(int i=0;i<inventory.length;i++) {
			ItemShelf itemShelf=new ItemShelf();
			itemShelf.setCode(codeNumber);
			itemShelf.setSoldOut(true);
			inventory[i]=itemShelf;
			Integer x= Integer.parseInt(codeNumber);x++;
			codeNumber=x.toString();
		}
	}
	
	void addItem(Item item, String codeNumber) throws Exception {
		for(ItemShelf itemShelf:inventory) {
			if(itemShelf.getCode().equals(codeNumber)) {
				if(itemShelf.isSoldOut()) {
					itemShelf.setItem(item);
					itemShelf.setSoldOut(false);
				}else {
					throw new Exception("Item cannot be placed here");
				}
			}
		}
	}
	
    public Item getItem(String codeNumber) throws Exception {

        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode().equals( codeNumber)) {
                if (itemShelf.isSoldOut()) {
                    throw new Exception("item already sold out");
                } else {

                    return itemShelf.getItem();
                }
            }
        }
        throw new Exception("Invalid Code");
    }
    
    void updateSoldItem(String codeNumber){
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode().equals(codeNumber)) {
            	itemShelf.setItem(null);
            	itemShelf.setSoldOut(true);
            }
        }
    }

}
