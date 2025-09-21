package com.walmart.practice.webApplication.ProductMgtSystem;

public class Invoice {
	Integer productPrice;
	Integer tax;
	Integer finalPrice;
	
	public Invoice generateInvoice(Order order){
		this.productPrice=order.getAmount();
		this.tax=34;
		this.finalPrice=this.productPrice+this.tax;
		return this;
	}
	
	@Override
	public String toString() {
		return "productPrice="+productPrice+" tax="+tax+" finalPrice="+finalPrice;
	}
}
