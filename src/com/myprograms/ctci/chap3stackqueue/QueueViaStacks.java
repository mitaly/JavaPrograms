package com.myprograms.ctci.chap3stackqueue;

import java.util.Stack;

public class QueueViaStacks {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.add(45);
		queue.add(4);
		queue.remove();
		queue.add(78);
		queue.add(2);
		queue.add(40);
		queue.remove();
		queue.add(24);
		queue.remove();
	}
}

class MyQueue{
	Stack<Integer> s1;
	Stack<Integer> s2;
	
	MyQueue(){
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}
	
	void add(int item) {
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		s1.push(item);
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		System.out.println("Pushed "+item);
	}

	void remove() {
		if(s2.isEmpty()) {
			System.out.println("Empty!");
			return;
		}else {
			System.out.println("Popped "+s2.pop());
		}
	}
}
