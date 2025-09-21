package com.walmart.practice.webApplication.ProductMgtSystem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
	String id;
	Integer userId;
	Address deliveryAddress;
	Map<Warehouse, Map<Product, Integer>>productIdVsCount;
	Integer amount;
	OrderStatus orderStatus;
	LocalDateTime create_ts;
}
