package com.walmart.practice.webApplication.ProductMgtSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonApplication {

	UserController userController;
	WarehouseController warehouseController;
	OrderController orderController;

	public AmazonApplication() {
		this.userController=new UserController();
		this.warehouseController=new WarehouseController();
		this.orderController=new OrderController();
		orderController.setWarehouseController(warehouseController);
		initialize();
	}
	
	public static void main(String args[]) throws Exception {
		AmazonApplication amazon=new AmazonApplication();
		amazon.placeOrder(1,"iphone");
	}
	
	private void placeOrder(Integer userId,String productName) throws Exception {
		
		
		//1.search Product
		Map<Warehouse,List<Product>>warehouseVsProducts1=warehouseController.getProductsFromAnyWarehouse(productName);
		
		//2.select product and add to the cart
		Map<Warehouse, Map<Product, Integer>> productVsCount = new HashMap<>();

		Warehouse warehouse1 = warehouseController.getWarehouseByName("tommy");
		Product product1 = warehouseVsProducts1.get(warehouse1).get(0); // pick first product
		Integer qty1=3;
		Cart cart=new Cart();
		cart.addProductToCart(warehouse1,product1,qty1);
		
		Map<Warehouse,List<Product>>warehouseVsProducts2=warehouseController.getProductsFromAnyWarehouse("milk");
		
		Warehouse warehouse2 = warehouseController.getWarehouseByName("redFort");
		Product product2 = warehouseVsProducts2.get(warehouse2).get(0); // pick first product
		Integer qty2=1;
		
		cart.addProductToCart(warehouse2,product2,qty2);
		
		//3.order is created for user
		Order order=orderController.createOrder(cart.getProductIdVsCount(),userId);
		
		//4.user books the product
		Invoice invoice =orderController.createBookingAndGenerateInvoice(order);
		
		System.out.println(invoice);
	}
	private void initialize() {
		
		//create user 
		createUsers();
		
		//create warehouse
		createWarehouse();
	}
	
	private void createUsers() {
		User user1=new User(1,"xingpin");
		User user2=new User(2,"putin");
		User user3=new User(3,"modi");
		userController.addUser(user1);
		userController.addUser(user2);
		userController.addUser(user3);
	}
	
	private void createWarehouse() {
		Product product1=new Product(1,"milk",34,30);
		Product product2=new Product(2,"egg",12,1300);
		Product product3=new Product(3,"iphone",34000,31);
		Product product4=new Product(4,"laptop",340000,3);
		Product product5=new Product(5,"bed",3400,31);
		
		Inventory inventory1=new Inventory();
		Inventory inventory2=new Inventory();

		
		inventory1.addProduct(product3);
		inventory1.addProduct(product5);inventory1.addProduct(product4);
		
		inventory2.addProduct(product1);inventory2.addProduct(product2);

		
		Address address1=new Address("bangalore");
		Address address2=new Address("delhi");

		
		Warehouse warehouse1=new Warehouse(2,"tommy",inventory1,address1);
		Warehouse warehouse2=new Warehouse(1,"redFort",inventory2,address2);

		
		warehouseController.addWarehouse(warehouse1);
		warehouseController.addWarehouse(warehouse2);

		
	}
	
}
