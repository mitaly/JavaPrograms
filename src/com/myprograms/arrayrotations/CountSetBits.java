package com.myprograms.arrayrotations;

public class CountSetBits {
	public static void count(int a) {
		int i = 32;
		int count = 0;
		while(i >= 0) {
			if((a & 1) != 0)
				count++;
			a = a >> 1;
			i--;
		}
		System.out.println(count);
	}
}
