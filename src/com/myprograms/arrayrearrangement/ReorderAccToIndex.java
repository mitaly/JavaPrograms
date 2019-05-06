package com.myprograms.arrayrearrangement;

public class ReorderAccToIndex {
	public void reorderUsingAuxiliaryArr(Integer[] arr, Integer[] index) {
		Integer[] resultArr = new Integer[arr.length];
		for(int i = 0; i<index.length; i++) 
			resultArr[index[i]] = arr[i];
		for(int x:resultArr) System.out.print(x+" ");
	}
	public void reorderWithoutAuxiliaryArr(Integer[] arr, Integer[] index) {
		for(int i = 0; i<arr.length; i++) {
			while(index[i] != i) {
				int oldIndex = index[index[i]];
				int oldNumber = arr[index[i]];
				
				index[index[i]] = index[i];
				arr[index[i]] = arr[i];
				
				index[i] = oldIndex;
				arr[i] = oldNumber;
			}
		}
	}
}	
