package com.myprograms.ctci.chap3stackqueue;

import java.util.Collections;
import java.util.Stack;

public class SortStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(9);
//		stack.push(0);
//		stack.push(-1);
//		stack.push(90);
//		stack.push(4);
		for(int i = 20; i>=0; i--) {
			stack.push(i);
		}
		Collections.reverse(mergeSort(stack));
		System.out.println(stack);
	}
	
	public static Stack<Integer> mergeSort(Stack<Integer> stack) {
		if(stack.size() <= 1)
			return stack;
		Stack<Integer> left = new Stack<>();
		Stack<Integer> right = new Stack<>();
		int count = 0;
		while(!stack.isEmpty()) {
			if(count%2 == 0) {
				left.push(stack.pop());
			}else {
				right.push(stack.pop());
			}
			count++;
		}
		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right, stack);
	}
	
	public static Stack<Integer> merge(Stack<Integer> left, Stack<Integer> right, Stack<Integer> stack) {
		while(left.size()>=1 && right.size() >= 1) {
			if(left.peek() >= right.peek()) {
				stack.push(left.pop());
			}else {
				stack.push(right.pop());
			}
		}
		while(!left.isEmpty()) {
			stack.push(left.pop());
		}
		while(!right.isEmpty()) {
			stack.push(right.pop());
		}
		Collections.reverse(stack);
		return stack;
	}
}
