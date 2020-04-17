package com.myprograms.ctci.chap2linkedlist;

class NodeCarryLast{
	Node node;
	int carry;
	Node last;
	public NodeCarryLast(Node node, int carry) {
		this.node = node;
		this.carry = carry;
	}
}
public class SumLists {
	public static void main(String[] args) {
		Node n1 = new Node(7);
		Node n2 = new Node(1);
		Node n3 = new Node(6);
		n1.next = n2; n2.next = n3;
		
		Node m1 = new Node(5);
		Node m2 = new Node(9);
		Node m3 = new Node(9);
		m1.next = m2; 
		m2.next = m3;
		
		Node res = sum(n1, m1);
//		Node res = sumUp1(n1, m1);
		LinkedListUtil.printLinkedList(n1);
		LinkedListUtil.printLinkedList(m1);
		LinkedListUtil.printLinkedList(res);
	}

	public static Node sum(Node l1, Node l2) {
		NodeCarryLast nodeCarryLast = sum(l1, l2, 0);
		if(nodeCarryLast.carry == 1) {
			nodeCarryLast.last.next = new Node(1);
		}
		return nodeCarryLast.node;
	}
	
	public static NodeCarryLast sum(Node l1, Node l2, int c) {
		if(l1 == null && l2 == null)
			return new NodeCarryLast(null, 0);
		int nd = c;
		if(l1 != null)
			nd += l1.data;
		if(l2 != null)
			nd += l2.data;
		int nc = nd >= 10 ? 1:0;
		nd = nd%10;
		
		Node newNode = new Node(nd);
		
		NodeCarryLast rest = sum(l1 == null ? null : l1.next, l2 == null ? null : l2.next,nc);
		rest.carry = nc;
		
		if(rest.node != null) {
			newNode.next = rest.node;
		}else {
			rest.last = newNode;
		}
		rest.node = newNode;
		return rest;
	}
	
	public static Node sumUp1(Node l1, Node l2) {
		int c = 0;
		Node start = null;
		Node end = null;
		
		while(l1 != null && l2 != null) {
			int nd = l1.data + l2.data + c;
			if(nd >= 10) {
				//update the new data - nd
				nd = nd%10;
				//new carry will be digit at second's place
				c = 1;
			}else {
				c = 0;
			}
			Node newNode = new Node(nd);
			if(start == null) {
				start = newNode;
				end = start;
			}
			else {
				end.next = newNode;
				end = newNode;
			}
			
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while(l1 != null) {
			int nd = l1.data + c;
			if(nd >= 10) {
				c = 1;
				nd = nd%10;
			}else {
				c = 0;
			}
			Node newNode = new Node(nd);
			if(start == null) {
				start = newNode;
				end = start;
			}
			else {
				end.next = newNode;
				end = newNode;
			}
			l1 = l1.next;
		}
		
		while(l2 != null) {
			int nd = l2.data + c;
			if(nd >= 10) {
				c = 1;
				nd = nd%10;
			}else {
				c = 0;
			}
			Node newNode = new Node(nd);
			if(start == null) {
				start = newNode;
				end = start;
			}
			else {
				end.next = newNode;
				end = newNode;
			}
			l2 = l2.next;
		}
		
		if(c == 1) {
			Node newNode = new Node(1);
			end.next = newNode;
		}
		return start;
	}

}

