package com.myprograms.ctci.chap3stackqueue;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacksDemo {
	public static void main(String[] args) {
		SetOfStack stack = new SetOfStack();
		for (int i = 0; i < 34; i++) {
			stack.push(i);
		}
		
//		for (int i = 0; i < 34; i++) {
//			stack.pop();
//		}
		stack.popAtIndex(5);
		stack.popAtIndex(10);
		stack.popAtIndex(2);
	}
}

class SetOfStack{
	List<Integer[]> listStacks;
	int stackLimit = 3;
	List<Integer> stackPtrs;
	
	SetOfStack(){
		listStacks = new ArrayList<>();
		stackPtrs = new ArrayList<Integer>();
	}
	
	public void push(int item) {
		if(listStacks.isEmpty()) {
			addNewStack(item);
			return;
		}
		int lastStackPtr = listStacks.size()-1;
		Integer[] stack = listStacks.get(lastStackPtr);
		int pointer = stackPtrs.get(lastStackPtr) + 1;
		if(pointer == stackLimit) {
			addNewStack(item);
			return;
		}else{
			stack[pointer] = item;
			stackPtrs.set(lastStackPtr, pointer);
		}
	}
	
	private void addNewStack(int item) {
		Integer[] newStack = new Integer[stackLimit];
		newStack[0] =item;
		stackPtrs.add(0);
		listStacks.add(newStack);
	}
	
	public void pop() {
		if(listStacks.isEmpty()) {
			System.out.println("Underflow!");
			return;
		}
		int lastStackPtr = listStacks.size() - 1;
		int pointer = stackPtrs.get(lastStackPtr) - 1;
		Integer[] stack = listStacks.get(lastStackPtr);
		
		if(pointer >= -1) {
			int data = stack[pointer+1];
			System.out.println("Popped "+data);
			stack[pointer+1] = 0;
			
			if(pointer == -1) {
				listStacks.remove(lastStackPtr);
				stackPtrs.remove(lastStackPtr);
			}else {
				stackPtrs.set(lastStackPtr, pointer);
			}
		}
	}
	
	public void popAtIndex(int subStack) {
		int stackPtr = stackPtrs.get(subStack);
		Integer[] stack = listStacks.get(subStack);
		
		if(subStack == listStacks.size()-1) {
			pop();
			return;
		}
		System.out.println("Popped "+stack[stackPtr]);
		
		int diff = stackLimit - stackPtr;
		// last stack
		if(diff == stackLimit) {
			listStacks.remove(stackPtr);
			stackPtrs.remove(stackPtr);
			return;
		}
		int stackPtrCurr = 0;
		for(int i = subStack+1; i<=listStacks.size()-1; i++) {
			Integer[] currStack = listStacks.get(i);
			stack[stackLimit-1] = currStack[0];
			stackPtrCurr = stackPtrs.get(i);
			
			if(stackPtrCurr == 0) {
				stackPtrs.remove(listStacks.size()-1);
				listStacks.remove(listStacks.size()-1);
				return;
			}
			int j = 1;
			for(; j<=stackPtrCurr; j++) {
				currStack[j-1] = currStack[j];
			}
			currStack[j-1] = 0;
			if(stackPtrCurr != stackLimit-1)
				stackPtrs.set(i, stackPtrCurr+1);
			stack = currStack;
		}
		if(!listStacks.isEmpty()) {
			stackPtrs.set(listStacks.size()-1, stackPtrCurr-1);
		}
	}
}
