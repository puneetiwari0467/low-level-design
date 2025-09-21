package com.walmart.practice.webApplication.ProductMgtSystem;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
	Map<Warehouse, Map<Product, Integer>> productIdVsCount;
	
	Cart(){
		productIdVsCount=new HashMap<>();
	}
	
	
	public void addProductToCart(Warehouse warehouse,Product product,Integer qty){
		productIdVsCount
	    .computeIfAbsent(warehouse, w -> new HashMap<>())
	    .put(product, qty);

	}
	
	public void viewProductsFromCart(){
		
	}
	
	public void removeProductsFromCart(){
		
	}
	
	public void emptyCart(){
		
	}
}
