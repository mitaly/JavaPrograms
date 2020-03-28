package com.myprograms.arrayrotations;

public class FlipIthBit {
	public static void flip(int a, int i) {
		a = a ^ (1 << i);
		System.out.println(a);
	}
}
