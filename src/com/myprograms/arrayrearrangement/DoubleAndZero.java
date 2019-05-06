package com.myprograms.arrayrearrangement;

public class DoubleAndZero {
	public void doubleAndMoveZeroesToEnd(Integer[] arr) {
		//double the number and make next number as zero
		for(int i = 0; i<arr.length-1; i++) {
			if(arr[i+1] == arr[i]) {
				arr[i] = 2*arr[i];
				arr[i+1] = 0;
			}	
		}
		//push all zeroes to end
		int count = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] != 0)
				arr[count++] = arr[i];
		}
		while(count < arr.length)
			arr[count++] = 0;
	}
}
