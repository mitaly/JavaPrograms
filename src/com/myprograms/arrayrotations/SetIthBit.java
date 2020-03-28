package com.myprograms.arrayrotations;

public class SetIthBit {
	public static void set(int a, int i) {
		a = a | (1 << i);
		System.out.println(a);
	}
}
