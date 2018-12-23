package com.myprograms.find_pair_having_sum;

public class FindingPairRotated {
	public int[] findingPairRotatedArray(Integer[] arr, int sum) {
		int pivot = findPivot(arr);
		int li = (pivot+1)%arr.length;
		int ri = pivot;
		while(li != ri) {
			if(arr[li]+arr[ri] == sum)
				return new int[] {arr[li], arr[ri]};
			else if(arr[li] + arr[ri] < sum)
				li = (li+1)%arr.length;
			else
				ri = (arr.length + ri - 1)%arr.length;
		}
		return null;
	}
	private int findPivot(Integer[] arr) {
		int pivot = -1;
		for(int i =0; i< arr.length; i++) {
			if(arr[i] > arr[i+1]){
				pivot = i;
				break;
			}
		}
		return pivot;
	}
}
