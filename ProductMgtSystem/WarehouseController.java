package com.walmart.practice.webApplication.ProductMgtSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarehouseController {
	List<Warehouse>warehouses;
	
	public WarehouseController() {
		this.warehouses=new ArrayList<>();
	}
	
	public void addWarehouse(Warehouse warehouse) {
		warehouses.add(warehouse);
	}
	
	public void removeWarehouse(Warehouse warehouse) {
		warehouses.remove(warehouse);
	}
	
	public Map<Warehouse,List<Product>> getProductsFromAnyWarehouse(String name) {
		Map<Warehouse,List<Product>>warehouseVsProduct=new HashMap<>();
		
		for(Warehouse warehouse:warehouses) {
			List<Product>matchingProducts=new ArrayList<>();
			
			for(Product product:warehouse.getInventory().getProducts()) {
				if(product.getName().equals(name)) {
					matchingProducts.add(product);
				}
			}
			if(matchingProducts.size()>0) {
				warehouseVsProduct.put(warehouse,matchingProducts);
			}
		}
		return warehouseVsProduct;
	}
	
	public boolean reserveProduct(Map<Warehouse, Map<Product, Integer>> productVsCount) {
		 // Step 1: Flatten and sort products by warehouse ID then product ID
	    List<Product> allProducts = productVsCount.entrySet().stream()
	            .sorted(Comparator.comparing(e -> e.getKey().getId())) // warehouse order
	            .flatMap(e -> e.getValue().keySet().stream()
	                    .sorted(Comparator.comparing(Product::getId))) // product order
	            .toList();
	    
	    for(Product product:allProducts) {
	    	synchronized(product) {
	    		Integer requiredQty=getRequiredQuantity(productVsCount,product);
		    	if(product.getQuantity()<requiredQty) {
		    		return false;
		    	}
	    	}
	    }
	    
	    for(Product product:allProducts) {
	    	synchronized(product) {
	    		Integer requiredQty=getRequiredQuantity(productVsCount,product);
		    	if(product.getQuantity()>=requiredQty) {
		    		product.setQuantity(product.getQuantity() - requiredQty);
		    	}
	    	}
	    }
	    
	    return true; 
	}
	
	
	public void releaseProducts(Map<Warehouse, Map<Product, Integer>> productVsCount ) {
		
		for(Map.Entry<Warehouse, Map<Product,Integer>>entry:productVsCount.entrySet()) {
			for(Map.Entry<Product,Integer>productEntry:entry.getValue().entrySet()) {
				Product product = productEntry.getKey();
	            int quantity = productEntry.getValue();
	            synchronized(product) {
	            	product.setQuantity(product.getQuantity()+quantity);
	            }
			}
		}
	}
	
	public Integer getRequiredQuantity(Map<Warehouse, Map<Product, Integer>> productVsCount,Product product){
		for(Map.Entry<Warehouse, Map<Product, Integer>>entry:productVsCount.entrySet()) {
			if (entry.getValue().containsKey(product)) {
				return entry.getValue().get(product);
			}
		}
		return 0;
	}
	
	public Product getProductFromWarehouse(Warehouse warehouse,String productName){
		return warehouse.getInventory().getProductByName(productName);
	}
	
	public Warehouse getWarehouseByName(String name) {
		for(Warehouse warehouse :warehouses) {
			if(warehouse.getName().equals(name)) {
				return warehouse;
			}
		}
		return null;
	}
}
