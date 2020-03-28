package com.myprograms.arrayrotations;

public class SearchInSortedNrotated {
	public static void search(int[] a, int e) {
		int pivot = findPivot(a, 0, a.length-1);
		
		int indexf = Integer.MIN_VALUE;
		if(pivot > -1) {
			indexf = binarySearch(a, 0, pivot-1, e);
			if(indexf < 0) 
				indexf = binarySearch(a, pivot, a.length-1, e);
		}else {
			indexf = binarySearch(a, 0, a.length-1, e);
		}
		System.out.println(indexf);
	}
	
	private static int findPivot(int[] a, int i, int j) {
		int mid = i+(j-i)/2;
		if(mid < j && a[mid] > a[mid+1])
			return mid+1;
		if(mid > i && a[mid] < a[mid-1])
			return mid;
		if(a[i] < a[mid])
			return findPivot(a, mid+1, j);
		return findPivot(a, i, mid-1);
	}
	private static int binarySearch(int a[], int i, int j, int e) {
		while(i<=j) {
			int mid = i+(j-i)/2;
			if(e == a[mid]) {
				return mid;
			}
			if(e < a[mid])
				j = mid-1;
			else
				i = mid+1;
		}
		return Integer.MIN_VALUE;
	}
}
