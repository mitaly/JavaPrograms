package com.myprograms.arrayrotations;

public class SplitAndAddToEnd {
	public void splitAndAddArrayToEnd(Integer[] arr, int splitIndex) {
		Integer[] leftSubArr = new Integer[splitIndex+1];
		for(int i = 0; i<splitIndex+1; i++)
			leftSubArr[i] = arr[i];
		for(int i = splitIndex+1; i<arr.length; i++)
			arr[i-(splitIndex+1)] = arr[i];
		for(int i = leftSubArr.length-1,  j = arr.length-1; i>=0; i--, j--)
			arr[j] = leftSubArr[i];
	}
	public void splitAndAddUsingRotation(Integer[] arr, int splitIndex) {
		for(int i =0; i<splitIndex+1; i++) {
			int first = arr[0];
			for(int j = 1; j<arr.length; j++)
				arr[j-1] = arr[j];
			arr[arr.length-1] = first;
		}
	}
}
