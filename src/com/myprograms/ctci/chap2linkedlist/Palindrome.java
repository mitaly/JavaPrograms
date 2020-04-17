package com.myprograms.ctci.chap2linkedlist;

import java.util.Stack;


public class Palindrome {
	public static void main(String[] args) {
		Node n1 = new Node(9);
		Node n2 = new Node(0);
		Node n3 = new Node(0);
		Node n4 = new Node(9);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		LinkedListUtil.printLinkedList(n1);
		System.out.println(checkPalindrome1(n1));
	}
	public static void getStringForward(Node node, StringBuilder builder) {
		if(node == null)
			return;
		builder.append(node.data);
		getStringForward(node.next, builder);
	}
	public static boolean checkPalindrome(Node node) {
		StringBuilder builder = new StringBuilder();
		getStringForward(node, builder);
		String string = builder.toString();
		int m = string.length() - 1;
		for(int i = 0; 	i<string.length()/2; i++) {
			if(string.charAt(i) != string.charAt(m-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkPalindrome1(Node head) {
		Stack<Integer> stack = new Stack<Integer>();
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null)
			slow = slow.next;
		
		while(slow != null) {
			int popped = stack.pop();
			if(slow.data != popped) {
				return false;	
			}
			slow = slow.next;
		}
		return true;
	}
}