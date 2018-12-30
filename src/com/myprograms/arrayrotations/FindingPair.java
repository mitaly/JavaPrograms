package com.myprograms.arrayrotations;

public class FindingPair {
	public int[] findPairHavingSum(Integer[] arr, int sum) {
		int li = 0, ri = arr.length -1;
		while(li < ri) {
			if(arr[li] + arr[ri] == sum)
				return new int[] {arr[li], arr[ri]};
			else if(arr[li] + arr[ri] < sum)
				li++;
			else
				ri--;
		}
		return null;
	}
}
