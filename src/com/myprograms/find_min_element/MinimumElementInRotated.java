package com.myprograms.find_min_element;

public class MinimumElementInRotated {
	public Integer findMinimumElementInRotatedArray(Integer[] arr){
		int li = 0, ri = arr.length -1, mid;
		while(li <= ri) {
			mid = (li + ri)/2;
			if(mid != 0) {
				if(arr[mid-1] > arr[mid])
					return arr[mid];
				else if(arr[mid] > arr[ri])
					li = mid + 1;
				else if(arr[mid] < arr[ri])
					ri = mid - 1;
			}else {
				return arr[mid];
			}
		}
		return null;
	}
}
