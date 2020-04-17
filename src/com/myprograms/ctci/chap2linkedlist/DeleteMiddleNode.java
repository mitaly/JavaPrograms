package com.myprograms.ctci.chap2linkedlist;

public class DeleteMiddleNode {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		
		delete(n4);
		LinkedListUtil.printLinkedList(n1);
	}
	public static boolean delete(Node node) {
		if(node == null || node.next == null)
			return false;
		node.data = node.next.data;
		node.next = node.next.next;
		return true;
	}
}
