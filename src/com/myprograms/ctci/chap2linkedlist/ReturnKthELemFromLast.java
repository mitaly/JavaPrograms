package com.myprograms.ctci.chap2linkedlist;

public class ReturnKthELemFromLast {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		Result res = returnKth(n1, 4);
		if(res.node != null)
			System.out.println("Kth node from end "+res.node.data);
		else
			System.out.println("no elem");
	}
	
	public static Result returnKth(Node head, int k) {
		if(head == null)
			return new Result(null, 0);
		Result res = returnKth(head.next, k);
		if(res.node == null) {
			res.c += 1;
			if(res.c == k) {
				res.node = head;
			}
		}
		return res;
	}
}

class Result{
	int c = 0;
	Node node;
	
	public Result(Node node, int c) {
		this.c = c;
		this.node = node;
	}
}
