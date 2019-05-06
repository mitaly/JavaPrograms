package com.myprograms.arrayrearrangement;

import java.util.HashSet;
import java.util.Set;

public class RearrangeAccToIndex1 {
	public void rearrange(Integer[] arr) {
		for(int i = 0; i<arr.length; i++) 
			arr[i]++;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] > 0)
				performRearrangement(arr, i);
		}
		for(int i = 0; i<arr.length; i++) {
			arr[i] = Math.abs(arr[i]) - 1;
		}
	}
	private void performRearrangement(Integer[] arr, int i) {
		int z = arr[i];
		while(arr[i] > 0) {
			int j = z-1;
			z = arr[j];
			arr[j] = -(i+1);
			i = j;
		}
		for(int x:arr) System.out.print(x+" ");
		System.out.println();
		Set<Integer> set = new HashSet<>();
//		set.in
	}
}
