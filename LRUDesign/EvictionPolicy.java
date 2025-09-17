package com.walmart.practice.webApplication.LRUDesign;

public interface EvictionPolicy<Key> {
	
	void keyAccessed(Key key);
	Key evictKey();
	
}
