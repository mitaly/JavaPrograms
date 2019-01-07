package com.myprograms.arrayrearrangement;

public class RearrangeEvenAndOddIndexes {
	public void rearrangeEvenAndOddIndexes(Integer[] arr) {
		sort(arr);
		int li = 0, ri = arr.length-1;
		Integer[] resultArr = new Integer[arr.length];
		for(int i = arr.length-1; i >= 0; i--) {
			if(i%2 == 0) {
				resultArr[i] = arr[li];
				li++;
			}else {
				resultArr[i] = arr[ri];
				ri--;
			}
		}
		for(int x : resultArr)
			System.out.print(x+" ");
	}
	private void sort(Integer[] arr) {
		for(int i = 0; i<arr.length-1; i++) {
			boolean swapped = false;
			for(int j = 0; j<arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped) break;
		}
	}
}
