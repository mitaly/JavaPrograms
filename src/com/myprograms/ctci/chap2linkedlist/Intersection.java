package com.myprograms.ctci.chap2linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
	public static void main(String[] args) {
		Node n1 = new Node(7);
		Node n2 = new Node(1);
		Node n3 = new Node(6);
		n1.next = n2; n2.next = n3;
		
		Node m1 = new Node(5);
		Node m2 = new Node(9);
		Node m3 = new Node(9);
		m1.next = n1; 
		m2.next = m3;
		
		System.out.println(isIntersecting3(n1, m1));
	}
	
	// O(m*n) time, O(1) space
	// For every node in list1 we check every node in list2 for same nodes
	public static boolean isIntersecting1(Node head1, Node head2) {
		Node l1 = head1;
		Node l2 = head2;
		while(l1 != null) {
			while(l2 != null) {
				if(l1 == l2) {
					return true;
				}
				l2 = l2.next;
			}
			l1 = l1.next;
		}
		return false;
	}
	
	//O(m+n) time, O(p) space, p - the number of elements in larger list
	//storing references in hashtable
	//Traverse list1 and store the addresses in set
	//Traverse the list2 and check whether node of list2 is present in set
	public static boolean isIntersecting(Node head1, Node head2) {
		Node l1 = head1;
		Node l2 = head2;
		
		Set<Node> references =  new HashSet<Node>();
		while(l1 != null) {
			references.add(l1);
			l1 = l1.next;
		}
		while(l2 != null) {
			if(references.contains(l2)) {
				return true;
			}
			l2 = l2.next;
		}
		return false;
	}
	
	//O(m+n) time, 0(1) space
	//Calculate the diff of lengths between 2 lists.
	//Take the larger list and move the pointer to point to 'diff' position
	//Now, traverse the 2 lists parallely to find the intersection(if any)
	public static boolean isIntersecting2(Node head1, Node head2) {
		int len1 = length(head1);
		int len2 = length(head2);
		int diff = len1 - len2;
		
		Node l1 = head1;
		Node l2 = head2;
		
		if(diff > 0) {
			l1 = moveToDiffPosition(head1, diff);
		}else if(diff < 0) {
			l2 = moveToDiffPosition(head2, diff);
		}
		System.out.println(diff);
		return checkIntersection(l1, l2);
	}
	
	public static boolean checkIntersection(Node l1, Node l2) {
		while(l1 != null) {
			if(l1 == l2)
				return true;
			l1 = l1.next;
			l2 = l2.next;
		}
		return false;
	}
	
	public static Node moveToDiffPosition(Node node, int diff) {
		diff = Math.abs(diff);
		Node n = node;
		int c = 0;
		while(diff != c && n != null) {
			n = n.next;
			c++;
		}
		return n;
	}
	
	public static int length(Node node) {
		if(node == null)
			return 0;
		return length(node.next) + 1;
	}
	
	// O(m+n) time, O(1) space
	// check the last node address, if equal means they intersected.
	public static boolean isIntersecting3(Node head1, Node head2) {
		Node l1 = head1;
		Node l2 = head2;
		
		if(l1 == null || l2 == null)
			return false;
		
		while(l1.next != null) {
			l1 = l1.next;
		}
		//now l1 points to last node
		
		while(l2.next != null) {
			l2 = l2.next;
		}
		//now l2 points to last node
		if(l1 == l2)
			return true;
		return false;
	}
}
