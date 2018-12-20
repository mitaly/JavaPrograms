package com.myprograms;

import com.myprograms.factorial.Factorial;

public class MyProgramMain {
	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		System.out.println(factorial.factorial(5));
	}
}
