package com.myprograms.ctci.chap2linkedlist;


class NodeAndCarry{
	Node node;
	int carry;
	NodeAndCarry(Node node, int carry){
		this.node = node;
		this.carry = carry;
	}
}

public class SumListsForward {
	public static void main(String[] args) {
		Node n1 = new Node(9);
		Node n2 = new Node(9);
		Node n3 = new Node(9);
		n1.next = n2; n2.next = n3;
		
		Node m1 = new Node(9);
		Node m2 = new Node(9);
//		Node m3 = new Node(0);
		m1.next = m2; 
//		m2.next = m3;
		
		Node res = sumForward(n1, m1);
		
		LinkedListUtil.printLinkedList(res);
	}
	public static NodeAndCarry sumRec(Node l1, Node l2) {
		if(l1 == null && l2 == null) {
			return new NodeAndCarry(null, 0);
		}
		NodeAndCarry nodeAndCarry = sumRec(l1.next, l2.next);
		int nd = l1.data + l2.data + nodeAndCarry.carry;
		int c = nd >=10 ? 1 : 0;

		nd = nd%10;
		
		Node newNode = new Node(nd);
		if(nodeAndCarry.node != null)
			newNode.next = nodeAndCarry.node;
		return new NodeAndCarry(newNode, c);
	}
	
	public static int length(Node node) {
		if(node == null)
			return 0;
		return length(node.next) + 1;
	} 
	
	public static Node padWithZeros(Node node, int count) {
		while(count != 0) {
			Node newZeroNode = new Node(0);
			newZeroNode.next = node;
			node = newZeroNode;
			count--;
		}
		return node;
	}
	
	public static Node sumForward(Node l1, Node l2) {
		int lenl1 = length(l1);
		int lenl2 = length(l2);
		int diff = lenl1 - lenl2;
		if(diff > 0) {
			l2 = padWithZeros(l2, diff);
		}else if(diff < 0) {
			l1 = padWithZeros(l1, diff);
		}
		
		LinkedListUtil.printLinkedList(l1);
		LinkedListUtil.printLinkedList(l2);
		
		NodeAndCarry nodeAndCarry = sumRec(l1, l2);
		if(nodeAndCarry.carry == 1) {
			Node newNode = new Node(1);
			newNode.next = nodeAndCarry.node;
			return newNode;
		}
		return nodeAndCarry.node;
	}
}

