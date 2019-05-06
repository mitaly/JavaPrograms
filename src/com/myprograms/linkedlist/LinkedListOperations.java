package com.myprograms.linkedlist;

public class LinkedListOperations {
	Node head = new Node();
	
	class Node{
		int data;
		Node next;
	}
	
	public void insertAtStart(int data) {
		Node node = new Node();
		node.data = data;
		node.next = head.next;
		head.next = node;
	}
	
	public void printList() {
		Node node = head.next;
		while(node != null) {
			System.out.print(node.data);
			node = node.next;
			if(node != null) System.out.print(" -> ");
		}
	}
	public void insertAfterData(int afterData, int data) {
		Node node = head;
		while(node.next != null && node.data != afterData)
			node = node.next;
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = node.next;
		node.next = newNode;
	}
	public void insertAtEnd(int data) {
		Node node = head;
		while(node.next != null)
			node = node.next;
		Node newNode = new Node();
		newNode.data = data; 
		node.next = newNode;
	}
}
