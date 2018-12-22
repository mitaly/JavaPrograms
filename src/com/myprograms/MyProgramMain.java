package com.myprograms;

import java.util.ArrayList;
import java.util.List;
import com.myprograms.factorial.Factorial;
import com.myprograms.prime_factorization_recursive.PrimeFactorizationRecursive;
import com.myprograms.tailrecursionfactorial.TailRecursionFactorial;

public class MyProgramMain {
	public static void main(String[] args) {
//		Factorial factorial = new Factorial();
//		System.out.println(factorial.factorial(5));
	
//		TailRecursionFactorial factorial = new TailRecursionFactorial();
//		System.out.println(factorial.factorial(25, 1));
		
		PrimeFactorizationRecursive factorization = new PrimeFactorizationRecursive();
		List<Integer> listPrimeFactors = new ArrayList<>();
		System.out.println(factorization.factorize(315, listPrimeFactors));
	}
}
