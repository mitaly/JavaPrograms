package com.myprograms.arrayrotations;

public class BinarySearch {
	public static void search(int[] a, int e) {
		int i = 0, j=a.length-1;
		while(i<=j) {
			int mid = i + (j-i)/2;
			if(e == a[mid]) {
				System.out.println("foudn at index:"+mid);
				return;
			}
			if(e < a[mid]) {
				j = mid-1;
			}else {
				i = mid+1;
			}
		}
		System.out.println("not found");
	}
}
