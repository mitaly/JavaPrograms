package com.myprograms.arrayrotations;

public class GetIthBit {
	public static void get(int a, int i) {
		a = a & (1 << i);
		if(a > 0)
			System.out.println(1);
		else
			System.out.println(0);
	}
}
