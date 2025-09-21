package com.walmart.practice.webApplication.ProductMgtSystem;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	Integer id;
	String name;
	Integer price;
	Integer quantity;
	ProductCategory productCategory;
	
	public Product(Integer id,String name,Integer price,Integer quantity) {
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
}
