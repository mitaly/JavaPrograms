package com.myprograms.ctci.chap2linkedlist;

public class LinkedListUtil {
	public static void printLinkedList(Node head) {
		Node n = head;
		while(n != null) {
			System.out.print(n.data +" -> ");
			n = n.next;
		}
		System.out.println();
	}
}

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
}