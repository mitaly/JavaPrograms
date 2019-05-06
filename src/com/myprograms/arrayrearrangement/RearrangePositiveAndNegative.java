package com.myprograms.arrayrearrangement;

import java.io.IOException;

public class RearrangePositiveAndNegative {
	//does not guarantee relative ordering of elements
	public void rearrangePositiveAndNegativeNumbers(Integer[] arr) {
		int i = partitionPositiveAndNegative(arr);
		int pos = i+1, neg = 0;
		while(pos < arr.length && neg < pos && arr[neg] < 0) {
			int temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;
			neg+=2;
			pos++;
		}
	}
	//using partitioning tech of quicksort algo.
	public int partitionPositiveAndNegative(Integer[] arr) {
		int x = 0, i = -1, j = 0;
		for(; j<arr.length; j++) {
			if(arr[j] < x) {
				int temp = arr[j]; 
				arr[j] = arr[++i];
				arr[i] = temp;
			}
		}
		return i;
	}
}
