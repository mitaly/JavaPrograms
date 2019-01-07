package com.myprograms.arrayrearrangement;

public class MinSwaps {
	public int minSwaps(Integer[] arr, int k) {
		boolean found = false;
		int j = 0, swaps = 0;
		for(int i = 0; i<arr.length; i++) {
			if(found && arr[i] <= k && arr[i-1] > k) {
				int temp = arr[i];
				arr[i] = arr[++j];
				arr[j] = temp;
				swaps++;
			}else if(!found && arr[i] <= k) {
				found = true;
				j = i;
			}
		}
		return swaps;
	}
}
