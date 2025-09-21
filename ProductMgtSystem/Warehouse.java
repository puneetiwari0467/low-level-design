package com.walmart.practice.webApplication.ProductMgtSystem;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warehouse {
	Integer id;
	String name;
	Inventory inventory;
	Address address;
	
	public Warehouse(Integer id,String name,Inventory inventory,Address address) {
		this.id=id;
		this.name=name;
		this.inventory=inventory;
		this.address=address;
	}
	
	public void addProductToInventory(Product product) {
		inventory.addProduct(product);
	}
	
	public void removeProductFromInventory(Product product) {
		inventory.removeProduct(product);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Warehouse other = (Warehouse) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
}
