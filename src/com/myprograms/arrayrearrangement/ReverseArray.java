package com.myprograms.arrayrearrangement;

public class ReverseArray {
	public void reverseArray(Integer[] arr) {
		int li = 0, ri = arr.length-1;
		while(li < ri) {
			int temp = arr[li];
			arr[li] = arr[ri];
			arr[ri] = temp;
			li++;ri--;
		}
	}
	public String reverseString(String str) {
		String resultStr = "";
		for(int index = str.length()-1; index >= 0; index--) {
			resultStr+=str.charAt(index);
		}
		return resultStr;
	}
}
