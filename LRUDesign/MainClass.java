package com.walmart.practice.webApplication.LRUDesign;

public class MainClass {
	
	public static void main(String [] args) {
		Cache<String, String>cache=new Cache(new LRUEvictionPolicy<String>(),new HashMapBasedStorage<>(5));
		
		cache.put("name", "PUNEET");
		cache.put("address", "PNo 7 bakak nagar");
		cache.put("age", "23");
		cache.put("moto", "chikni");
		System.out.println(cache.get("name"));
		cache.put("choto", "pikato");
		System.out.println(cache.get("name"));
		cache.put("chuni", "eded");
		System.out.println(cache.get("name"));
	}
}
