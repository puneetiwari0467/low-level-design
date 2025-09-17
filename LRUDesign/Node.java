package com.walmart.practice.webApplication.LRUDesign;

import lombok.Getter;

@Getter
public class Node<E> {
	Node<E> next;
	Node<E>prev;
	E element;
	
	public Node(E element) {
		this.element=element;
		this.next=null;
		this.prev=null;
	}
}
