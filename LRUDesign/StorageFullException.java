package com.walmart.practice.webApplication.LRUDesign;

public class StorageFullException extends RuntimeException{
	
	public StorageFullException(String msg) {
		super(msg);
	}
}
