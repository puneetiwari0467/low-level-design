package com.walmart.practice.webApplication.LRUDesign;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key,Value> implements Storage<Key,Value> {
	
	Map<Key,Value>storage;
	private final Integer capacity;
	
	public HashMapBasedStorage(Integer capacity) {
		this.capacity=capacity;
		this.storage=new HashMap<>();
	}

	@Override
	public Value get(Key key) {
		//if(isStorageFull())throw new NotFoundException(key+" key does not exist");
		return storage.get(key);
	}

	@Override
	public void add(Key key, Value value) {
		System.out.println(key + "->"+value+"<=>"+isStorageFull() );
		if(isStorageFull())throw new StorageFullException("Capacity Full ....");
		storage.put(key,value);
		
	}

	@Override
	public void removeKey(Key key) {
		if(!storage.containsKey(key))throw new NotFoundException(key+"does not exist in cache");
		storage.remove(key);
	}
	
	private boolean isStorageFull() {
		return storage.size()==capacity;
	}
	
	

}
