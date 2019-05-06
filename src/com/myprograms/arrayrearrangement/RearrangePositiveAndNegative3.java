package com.myprograms.arrayrearrangement;

public class RearrangePositiveAndNegative3 {
	//modified insertion sort
	//O(n2) time
	public void rearrange(Integer[] arr) {
		int j = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] < 0) {
//				rotate right by 1 position
				int temp = arr[i];
				for(int k = i; k>j; k--)
					arr[k] = arr[k-1];
				arr[j] = temp;
				j++;
			}
		}
	}
}
