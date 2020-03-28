package com.myprograms.arrayrotations;

import com.myprograms.gcd.GCD;

public class ArrayRotation {
	public Integer[] rotateRight(Integer[] arr, int d) {
		Integer[] tempArr = new Integer[arr.length];
		for(int i=0; i< arr.length; i++) {
			tempArr[(i+d)%arr.length] = arr[i];
		}
		return tempArr;
	}
	public Integer[] rotateLeftUsingTempArray(Integer[] arr, int d) {
		Integer[] tempArr = new Integer[arr.length];
		for(int i=0; i < arr.length; i++) {
			if(isPositive(i-d)) 
				tempArr[i-d] = arr[i];
			else
				tempArr[i+arr.length-d] = arr[i];
		}
		return tempArr;
	}
	public Integer[] rotateLeftOneByOneStep(Integer[] arr, int d) {
		if(d > 0) {
			int temp = arr[0];
			for(int i = 1; i< arr.length; i++)
				arr[i-1] = arr[i];
			arr[arr.length-1] = temp;
			rotateLeftOneByOneStep(arr, --d);
		}
		return arr;
	}
//	public Integer[] rotateJugglingAlgo(Integer[] arr, int d) {
//		GCD gcd = new GCD();
//		int sets = gcd.gcd(arr.length, d);
//		for(int i=0; i<d; i++) {
//			int temp = arr[i];
//			for(int j=d; j<(sets-1); j++) {
//				arr[j-d] = arr[j];
//			}
//			arr[arr.length-d+i] = arr[i];
//		}
//		return arr;
//	}
	public Integer[] rotateLeftReversalAlgo(Integer[] arr, int d) {
		reverseArray(arr, 0, d-1);
		reverseArray(arr, d, arr.length-1);
		reverseArray(arr, 0, arr.length-1);
		return arr;
	}
	private void reverseArray(Integer[] arr, int start, int end) {
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	private boolean isPositive(int n) {
		return n>=0;
	}
	public Integer[] rotateRightReversalAlgorithm(Integer[] arr, int d) {
		reverseArray(arr, 0, arr.length-1);
		reverseArray(arr, 0, d-1);
		reverseArray(arr, d, arr.length-1);
		return arr;
	}
	
	public Integer[] rotate(Integer[] arr, int d) {
		reverseArray(arr, 0, arr.length-1-d);
		reverseArray(arr, arr.length-d, arr.length-1);
		reverseArray(arr, 0, arr.length-1);
		return arr;
	}
}
	