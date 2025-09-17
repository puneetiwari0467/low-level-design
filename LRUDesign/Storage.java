package com.walmart.practice.webApplication.LRUDesign;

public interface Storage<Key,Value> {
	
	Value get(Key key);
	
	void add(Key key,Value value); 
	
	void removeKey(Key key);
}
