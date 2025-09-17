package com.walmart.practice.webApplication.LRUDesign;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{

	private DoublyLinkedList<Key>dll;
	private Map<Key,Node<Key>>mapper;
	
	public LRUEvictionPolicy() {
		dll=new DoublyLinkedList<>();
		mapper=new HashMap<Key,Node<Key>>();
	}
	
	@Override
	public void keyAccessed(Key key) {
		if(mapper.containsKey(key)) {
			dll.detachNode(mapper.get(key));
			dll.addNodeAtLast(mapper.get(key));
		}else {	
			Node<Key> newNode=dll.addElementAtLast(key);
			mapper.put(key,newNode);
		}
	}

	@Override
	public Key evictKey() {
		Node<Key>first=dll.getFirstNode();
		if(first==null) {
			return null;
		}
		dll.detachNode(first);
		return first.getElement();
	}
	
	
}
