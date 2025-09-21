package com.walmart.practice.webApplication.ProductMgtSystem;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inventory {
	List<Product>products;
	List<ProductCategory>productCategory;
	
	public Inventory() {
		this.products=new ArrayList<>();
		this.productCategory=new ArrayList<>();
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void removeProduct(Product product) {
		products.remove(product);
	}
	
	public Product getProductByName(String name) {
		 return products.stream()
		            .filter(p -> p.getName().equalsIgnoreCase(name))
		            .findFirst()  
		            .orElse(null); 
	}
}
