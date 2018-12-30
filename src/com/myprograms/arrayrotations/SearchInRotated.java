package com.myprograms.arrayrotations;

public class SearchInRotated {
	public int searchInRotatedArray(Integer[] arr, int element) {
		//find pivot - index where next element is lesser than the current element
		int pivot = -1;
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] > arr[i+1]) {
				pivot = i;
				break;
			}
		}
		if(pivot == -1)
			return binarySearch(arr, 0, arr.length-1, element);
		else {
			if(arr[0] <= element)
				return binarySearch(arr, 0, pivot, element);
			else
				return binarySearch(arr, pivot+1,arr.length-1, element);
		}
	}
	
	private int binarySearch(Integer[] arr, int li, int ri, int element) {
		while(li <= ri) {
			int mid = (li+ri)/2;
			if(arr[mid] == element)
				return mid;
			else if(arr[mid] < element)
				li = mid + 1;
			else
				ri = mid - 1;
		}
		return -1;
	}
	
}
