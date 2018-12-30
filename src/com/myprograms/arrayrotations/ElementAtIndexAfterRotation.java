package com.myprograms.arrayrotations;

public class ElementAtIndexAfterRotation {
	//Brute force method
	public Integer findElementAtGivenIndex(Integer[] arr, 
			Integer[][] rotationsArr, int index) {
		if(index <= arr.length-1 && index >= 0) {
			for(int i =0; i<rotationsArr.length; i++) {
				int li = rotationsArr[i][0];
				int ri = rotationsArr[i][1];
				rotateRight(arr,li,ri);
			}
			return arr[index];
		}else
			return null;

	}
	private void rotateRight(Integer[] arr, int li, int ri) {
		int temp = arr[ri];
		for(int i = ri-1; i>=li; i--)
			arr[i+1] = arr[i];
		arr[li] = temp;
	}
}
