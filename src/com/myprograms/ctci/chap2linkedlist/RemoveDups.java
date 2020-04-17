package com.myprograms.ctci.chap2linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {
	public static void main(String[] args) {
		Node n1 = new Node(2);
		Node n2 = new Node(20);
		Node n3 = new Node(20);
		Node n4 = new Node(20);
		Node n5 = new Node(200);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		//10 -> 20 -> 1 -> 20 -> 4
		
		LinkedListUtil.printLinkedList(n1);
		removeDups2(n1);
		LinkedListUtil.printLinkedList(n1);
	}
	//using extra space
	public static void removeDups(Node head) {
		Set<Integer> set = new HashSet<Integer>();
		if(head == null)
			return;
		Node n = head;
		Node prv = null;
		
		while(n != null) {
			if(set.contains(n.data)) {
				prv.next = n.next;
			}else {
				set.add(n.data);
				prv = n;
			}
			n = n.next;
		}
	}
	
	//using extra space
	public static void removeDups2(Node head) {
		Set<Integer> set = new HashSet<Integer>();
		if(head == null)
			return;
		Node n = head;
		set.add(head.data);
		while(n.next != null) {
			if(set.contains(n.next.data)) {
				n.next = n.next.next;
			}else {
				set.add(n.next.data);
				n = n.next;
			}
		}
	}
	
	//without using space
	public static void removeDups1(Node head) {
		Node r = head;
		while(r != null) {
			Node c = r;
			while(c.next != null) {
				if(r.data == c.next.data) {
					c.next = c.next.next;
				}else {
					c = c.next;
				}
			}
			r = r.next;
		}
	}
}