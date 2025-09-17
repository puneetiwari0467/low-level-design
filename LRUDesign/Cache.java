package com.walmart.practice.webApplication.LRUDesign;

import javax.management.RuntimeErrorException;

public class Cache<Key,Value> {

	private final Storage<Key,Value> storage;
	private final EvictionPolicy<Key>evictionPolicy;
	
	public Cache(EvictionPolicy<Key>evictionPolicy,Storage<Key,Value> storage) {
		this.evictionPolicy=evictionPolicy;
		this.storage=storage;
	}
	

	public Value get(Key key) {
		try {
			Value value=this.storage.get(key);
			this.evictionPolicy.keyAccessed(key);
			return value;
		}catch(Exception ex) {
			System.out.println("Key not found "+ex.getMessage());
			return null;
		}
	}


	public void put(Key key, Value value) {
		try {
			this.storage.add(key,value);
			this.evictionPolicy.keyAccessed(key);
		}catch(Exception ex) {
			System.out.println("Cache full "+ex.getMessage());
			Key keyToRemove=evictionPolicy.evictKey();
			if(keyToRemove==null) {
				throw new RuntimeErrorException(null, "Unexpected happened");
			}
			this.storage.removeKey(keyToRemove);
			System.out.println("Key removed from cache: "+ keyToRemove);
			put(key,value);
		}
		
	}

}
