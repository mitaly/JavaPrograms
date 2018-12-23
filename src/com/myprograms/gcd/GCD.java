package com.myprograms.gcd;

public class GCD {
	public int gcd(int n1, int n2) {
		if(n2 > n1) {
			int t = n1;
			n1 = n2;
			n2 = t;
		}
		while(true) {
			if(n2 % n1 == 0)
				return n1;
			else {
				int temp = n1;
				n1 = n2 % n1;
				n2 = temp;
			}
		}
	}
}
