package com.myprograms.arrayrearrangement;

public class RearrangePositiveAndNegative1 {
	//O(n2) time
	//using rotate right method
	//negative and positive numbers at alternative positions
	//relative ordering is maintained
	public void rearrangePositiveAndNegativeNumbers(Integer[] arr) {
		for(int i = 0; i<arr.length;i++ ) {
			if(i%2 == 0 && arr[i] >= 0 ) {
				for(int j = i+1; j<arr.length; j++) {
					if(arr[j] < 0) {
						//rotate right from index i to j
						rotateRight(arr, i, j);
						break;
					}
				}
			}else if(i%2 != 0 && arr[i] < 0) {
				for(int j = i+1; j<arr.length; j++) {
					if(arr[j] >= 0) {
						rotateRight(arr, i, j);
						break;
					}
				}
			}
		}
	}
	private void rotateRight(Integer[] arr, int li, int ri) {
		int temp = arr[ri];
		for(int i = ri - 1; i>=li; i--) {
			arr[i+1] = arr[i];
		}
		arr[li] = temp;
	}
}
