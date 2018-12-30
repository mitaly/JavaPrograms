package com.myprograms.arrayrotations;

public class FindMaximumSum {
	public int findMaximumValueOfSum(Integer[] arr) {
		Integer[] sumArr = new Integer[arr.length-1];
		for(int rotation = 1; rotation < arr.length; rotation++) {
			Integer[] tempArr = rotateArrUsingTempArr(arr, rotation);
			int sum = 0;
			for(int i = 0; i < tempArr.length; i++) {
				sum+=(tempArr[i]*i);
			}
			sumArr[rotation-1] = sum;
		}
		return findMaximum(sumArr);
	}
	private int findMaximum(Integer[] sumArr) {
		int largest = sumArr[0];
		for(int i = 1; i < sumArr.length; i++) {
			if(largest < sumArr[i])
				largest = sumArr[i];
		}
		return largest;
	}
	private Integer[] rotateArrUsingTempArr(Integer[] arr, int d) {
		Integer[] resultArr = new Integer[arr.length];
		for(int i = 0; i< arr.length; i++) {
			resultArr[(arr.length + i -d)%arr.length] = arr[i];
		}
		return resultArr;
	}
}
