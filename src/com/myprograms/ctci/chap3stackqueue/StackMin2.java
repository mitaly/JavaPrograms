package com.myprograms.ctci.chap3stackqueue;

import java.util.Stack;

public class StackMin2 {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(3);
		myStack.push(5);
		myStack.push(2);
		myStack.push(1);
		myStack.push(1);
		myStack.push(-1);
		
		myStack.pop();
		myStack.pop();
		myStack.pop();
		myStack.pop();
		myStack.pop();
		myStack.pop();
	}
}

class MyStack{
	Stack<Integer> stack = new Stack<Integer>();
	int min = Integer.MIN_VALUE;
	
	public void push(Integer item) {
		if(stack.isEmpty()){
			min = item;
		}else if(item < min) {
			int y = 2*item - min;
			min = item;
			item = y;
		}
		stack.push(item);
		System.out.println("Pushed");
	}
	
	public void pop() {
		if(stack.isEmpty())
			return;
		int item = stack.pop();
		if(item < min) {
			min = 2*min - item;
		}
		System.out.println("Popped");
	}
	
	public void min() {
		System.out.println("Min "+min);
	}
}