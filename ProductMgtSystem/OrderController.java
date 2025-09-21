package com.walmart.practice.webApplication.ProductMgtSystem;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderController {
	
	WarehouseController warehouseController;
	PaymentService paymentService;
	Invoice invoice;
	
	public OrderController() {
		this.paymentService=new PaymentService();
		this.invoice=new Invoice();
	}
	
	public Order createOrder(Map<Warehouse, Map<Product, Integer>> productVsCount,Integer userId){
		Order order=new Order();
		order.setId(UUID.randomUUID().toString());
		order.setUserId(userId);
		order.setProductIdVsCount(productVsCount);
		order.setOrderStatus(OrderStatus.CREATED);
		order.setAmount(computeAmount(productVsCount));
		order.setCreate_ts(LocalDateTime.now());
		return order;
	}
	
	public Integer computeAmount(Map<Warehouse, Map<Product, Integer>>productVsCount){
		Integer amount=0;
		for(Entry<Warehouse, Map<Product, Integer>> entry:productVsCount.entrySet()) {
			for(Map.Entry<Product,Integer>en:entry.getValue().entrySet()) {
				amount+=en.getKey().getPrice()*en.getValue();
			}
		}
		return amount;
	}
	
	public Invoice createBookingAndGenerateInvoice(Order order) throws Exception{
		boolean available=warehouseController.reserveProduct(order.getProductIdVsCount());
		if(!available) {
			order.setOrderStatus(OrderStatus.FAILED);
			throw new Exception("Already booked");
		}
		boolean paid=paymentService.processPayment();
		if(paid) {
			order.setOrderStatus(OrderStatus.CONFIRMED);
		}else {
			warehouseController.releaseProducts(order.getProductIdVsCount());
			order.setOrderStatus(OrderStatus.FAILED);
			throw new Exception("Payment faileed");
		}
		return generateInvoice(order);
	}
	
	public Invoice generateInvoice(Order order){
		return invoice.generateInvoice(order);
	}
	
}
