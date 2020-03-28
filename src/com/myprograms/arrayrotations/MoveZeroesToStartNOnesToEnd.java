package com.myprograms.arrayrotations;

public class MoveZeroesToStartNOnesToEnd {
	public static void move(int[] a) {
		// move zeroes at start
		int j = a.length-1;
		for(int i = a.length-1; i>=0; i--) {
			if(a[i] != 0) {
				a[j--] = a[i];
			}
		}
		int c = j;
		while(j >= 0) {
			a[j--] = 0;
		}
		
		//move ones at the end
		for(int i = c; i<a.length; i++) {
			if(a[i] != 1) {
				a[c++] = a[i];
			}
		}
		
		while(c < a.length) {
			a[c++] = 1;
		}
		
		for(int x: a)
			System.out.println(x);
	}
}
