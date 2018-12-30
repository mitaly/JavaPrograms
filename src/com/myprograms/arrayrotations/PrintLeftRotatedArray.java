package com.myprograms.arrayrotations;

public class PrintLeftRotatedArray {
	public void printAndRotateLeft(Integer[] arr, int d) {
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[(i+d)%arr.length]+" ");
		}
	}
}
