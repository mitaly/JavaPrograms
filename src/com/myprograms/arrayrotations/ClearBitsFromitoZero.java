package com.myprograms.arrayrotations;

public class ClearBitsFromitoZero {
	public static void clear(int a, int bit) {
		for(int i = 0; i<= bit; i++) {
			a = a & ~(1 << i);
		}
		System.out.println(a);
	}
	public static void turnOfKthBit(int a, int k) {
		a = a & ~(1 << k); 
		System.out.println(a);
	}
}
