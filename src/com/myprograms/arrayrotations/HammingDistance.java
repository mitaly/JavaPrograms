package com.myprograms.arrayrotations;

import java.util.ArrayList;
import java.util.HashMap;

public class HammingDistance {
	public HashMap<Integer, Integer[]> findArrayHavingMaximumHammingDistance(Integer[] a1) {
		Integer[] a2 = new Integer[a1.length];
		for(int i =0; i<a1.length; i++)
			a2[i] = a1[i];
		
		Integer[] arrHammingDistance = new Integer[a1.length-1];
		for(int rotation = 0; rotation < a1.length-1; rotation++) {
			int hammingDistance = 0;
			int temp = a2[0];
			for(int i = 1; i<a1.length; i++) {
				a2[i-1] = a2[i];
				if(a2[i-1] != a1[i-1])
					hammingDistance++;
			}
			a2[a2.length-1] = temp;
			if(a2[a2.length-1] != a1[a1.length-1])
				hammingDistance++;
			arrHammingDistance[rotation] = hammingDistance;
		}
		int indexHavingMaxHamming = findRotationHavingMaximumHammingDistance(arrHammingDistance);
		rotateLeftUsingReversal(a1, indexHavingMaxHamming+1);
		HashMap<Integer, Integer[]> resultMap = new HashMap<>();
		resultMap.put(arrHammingDistance[indexHavingMaxHamming], a1);
		return resultMap;
	}
	
	private void rotateLeftUsingReversal(Integer[] arr, int d) {
		reverseArray(arr, 0, d-1);
		reverseArray(arr, d, arr.length-1);
		reverseArray(arr, 0, arr.length-1);
	}
	private void reverseArray(Integer[] arr, int li, int ri) {
		while(li <= ri) {
			int temp = arr[li];
			arr[li] = arr[ri];
			arr[ri] = temp;
			li++;
			ri--;
		}
	}
	private int findRotationHavingMaximumHammingDistance(Integer[] arrHammingDistance) {
		int indexHavingMaxHamming = 0;
		for(int i =0; i<arrHammingDistance.length; i++) {
			System.out.println(arrHammingDistance[i]);
		}
		for(int i =1; i<arrHammingDistance.length; i++) {
			if(arrHammingDistance[indexHavingMaxHamming] < arrHammingDistance[i])
				indexHavingMaxHamming = i;
		}
		return indexHavingMaxHamming;
	}
}
