package com.myprograms.arrayrearrangement;

public class RearrangePositiveAndNegative2 {
	//all negative then all positive
	//relative order maintained
	//O(n2) time
	//'0's be the separation of positive and negative numbers
	public void rearrangePositiveAndNegativeNumbers(Integer[] arr) {
		for(int i = 0; i<arr.length; i++) {
			boolean rotatedRight = false;
			if(arr[i] >= 0) {
				for(int j = i+1; j<arr.length; j++) {
					if(arr[j] < 0) {
						//rotate right
						int temp = arr[j];
						for(int k = j-1; k>=i; k--)
							arr[k+1] = arr[k];
						arr[i] = temp;
						rotatedRight = true;
						break;
					}
				}
				//move zeroes between positive and negative numbers
				if(!rotatedRight) {
					for(int k = i; k<arr.length; k++) {
						boolean rotated = false;
						if(arr[k] != 0) {
							for(int l = k+1; l<arr.length; l++) {
								if(arr[l] == 0) {
									int temp = arr[l];
									for(int m = l-1; m>= k; m--)
										arr[m+1] = arr[m];
									arr[k] = temp;
									rotated = true;
									break;
								}
							}
							if(!rotated) break;
						}
					}
					break;
				}
			}
		}
	}
}
