package com.myprograms.ctci.chap3stackqueue;

public class ThreeInOne {
	int stackSize = 4;
	int stacks[] = new int[stackSize*3];
	int stackPtr[] = {-1, -1, -1};
	
	public static void main(String[] args) {
		ThreeInOne threeInOne = new ThreeInOne();
		threeInOne.performStackOps();
	}
	
	public void performStackOps() {
		push(0, 90);
		push(2, 89);
		pop(1);
		pop(2);
		push(2, 56);
		push(2, 67);
		push(2, 78);
		pop(2);
	}
	
	public void push(int stackNum, int item) {
		stackPtr[stackNum] += 1;
		if(stackPtr[stackNum] >= stackSize) {
			System.out.println("Overflow!");
			stackPtr[stackNum] -= 1;
			return;
		}
		int pos = stackNum * stackSize + stackPtr[stackNum];
		stacks[pos] = item;
		System.out.println("Item "+ item+"pushed at position "+pos);
	}
	
	public void pop(int stackNum) {
		if(stackPtr[stackNum] == -1) {
			System.out.println("Underflow!");
			return;
		}
		int pos = stackNum * stackSize + stackPtr[stackNum];
		int data = stacks[pos];
		stackPtr[stackNum] -= 1;
		stacks[pos] = 0;
		System.out.println("Popped "+data);
	}
	
	public boolean isEmpty(int stackNum) {
		return stackPtr[stackNum] == -1 ? true : false;
	}
	
	public void peek(int stackNum) {
		if(stackPtr[stackNum] == -1) {
			System.out.println("No element found");
			return;
		}
		System.out.println("TOS: "+stacks[stackNum * stackSize + stackPtr[stackNum]]);
	}
}
