package com.myprograms.arrayrotations;

public class MoveAllZeroesTorigth {
	public static void move(int[] a) {
		int j = 0;
		for(int i = 0; i<a.length; i++) {
			if(a[i] != 0) {
				a[j++] = a[i];
			}
		}
		while(j < a.length) {
			a[j++] = 0;
		}
		
		for(int x: a) {
			System.out.println(x);
		}
	}
}
