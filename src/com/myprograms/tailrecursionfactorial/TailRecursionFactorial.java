package com.myprograms.tailrecursionfactorial;

public class TailRecursionFactorial {
	public int factorial(int n,  int a) {
		if(n==0 || n==1)
			return a;
		else
			return factorial(n-1, n*a);
	}
}
