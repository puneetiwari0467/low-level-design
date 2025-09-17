package com.walmart.fixit.LRUCacheDesign;


import java.util.NoSuchElementException;

public class DoublyLinkedList<E>  {
	private final Node<E> head;
    private final Node<E> tail;

    DoublyLinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
    }

    void detachNode(Node<E> node) {
    	if(node==null)return ;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void addNodeAtLast(Node<E> node) {
    	Node tailprev=tail.prev;
    	tailprev.next=node;
    	node.next=tail;
    	tail.prev=node;
    	node.prev=tailprev;
    }

    public Node getFirstNode() throws NoSuchElementException {
        if (head.next == tail) {
            return null;
        }
        return head.next;
    }
    
}
