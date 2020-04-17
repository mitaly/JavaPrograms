package com.myprograms.ctci.chap2linkedlist;

public class Partition {
	public static void main(String[] args) {
		Node n1 = new Node(3);
		Node n2 = new Node(5);
		Node n3 = new Node(8);
		Node n4 = new Node(5);
		Node n5 = new Node(10);
		Node n6 = new Node(2);
		Node n7 = new Node(1);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n7;
		
//		partition(n1, 5);
		
		Node newHead = partition1(n1, 5);
		LinkedListUtil.printLinkedList(newHead);
	}
	//quicksort partition algo
	public static void partition(Node head, int data) {
		Node i = null;
		Node j = head;
		while(j != null) {
			if(j.data < data) {
				if(i == null)
					i = head;
				else
					i = i.next;
				//swap
				int temp = i.data;
				i.data = j.data;
				j.data = temp;
			}
			j = j.next;
		}
	}
	
	public static Node partition1(Node head, int data) {
		if(head == null)
			return null;
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		Node n = head;
		
		while(n != null) {
			//very imp step
			Node next = n.next;
			n.next = null;
			
			if(n.data < data) {
				if(beforeStart == null) {
					beforeStart = n;
					beforeEnd = n;
				}else {
					beforeEnd.next = n;
					beforeEnd = n;
				}
			}else {
				if(afterStart == null) {
					afterStart = n;
					afterEnd = n;
				}else {
					afterEnd.next = n;
					afterEnd = n;
				}
			}
			n = next;
		}
		
		if(beforeStart == null)
			return afterStart;
		beforeEnd.next = afterStart;
		return beforeStart;
	}
}
