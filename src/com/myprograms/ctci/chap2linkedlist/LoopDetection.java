package com.myprograms.ctci.chap2linkedlist;

public class LoopDetection {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n1.next = n2; 
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;
		
		System.out.println(detectAndReturnBegNode1(n1).data);
	}
	
	public static Node detectAndReturnBegNode1(Node head) {
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}
		if(fast == null || fast.next == null)
			return null;
		
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
	
	public static Node detectAndReturnBegNode(Node head) {
		Node temp = new Node(Integer.MAX_VALUE);
		Node n = head;
		while(n != null) {
			Node next = n.next;
			if(next == temp)
				return n;
			n.next = temp;
			n = next;
		}
		return null;
	}
}
