package com.myprograms.arrayrearrangement;

public class MoveZerosToEnd {
	//O(n square) time and O(1) space
	public void moveZeroesToEnd(Integer[] arr) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == 0) {
				for(int j = i+1; j<arr.length; j++) {
					if(arr[j] != 0) {
						rotateRight(arr, i, j);
						break;
					}
				}
			}
		}
	}
	private void rotateRight(Integer[] arr, int li, int ri) {
		int temp = arr[ri];
		for(int i = ri-1; i>=li; i--) {
			arr[i+1] = arr[i];
		}
		arr[li] = temp;
	}
	//O(n) time solution with O(1) space
	public void moveZeroesToEnd1(Integer[] arr) {
		int count = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] != 0)
				arr[count++] = arr[i];
		}
		while(count < arr.length)
			arr[count++] = 0;
	}
	//O(n) time solution with O(1) space
	//with single iteration
	public void moveZeroesToEnd2(Integer[] arr) {
		int count = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] != 0) {
				int temp = arr[count];
				arr[count++] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
		