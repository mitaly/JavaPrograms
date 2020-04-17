package com.myprograms.ctci.chap3stackqueue;

public class StackMin {
	StackNode top = null;

	public static void main(String[] args) {
		StackMin obj = new StackMin();
		obj.performStackOps();
	}
	
	public void performStackOps() {
		push(10);
		push(2);
		push(4);
		min();
		push(1);
		min();
		pop();
		min();
	}
	
	public void push(int data) {
		StackNode stackNode = new StackNode(data);
		stackNode.next = top;
		if(top != null)
			stackNode.lastMin = top.lastMin > data ? data : top.lastMin;
		else
			stackNode.lastMin = data;
		top = stackNode;
		System.out.println("Pushed "+data);
	}
	
	public void pop() {
		if(top == null) {
			System.out.println("Underflow!");
			return;
		}
		int data = top.data;
		top = top.next;
		System.out.println("Popped "+data);
	}
	
	public void min() {
		if(top == null)
			System.out.println("Stack is empty!");
		int min = top.lastMin;
		System.out.println("Minimum element is "+min);
	}
}
class StackNode{
	int data;
	int lastMin;
	StackNode next;
	
	public StackNode(int data) {
		this.data = data;
	}
}