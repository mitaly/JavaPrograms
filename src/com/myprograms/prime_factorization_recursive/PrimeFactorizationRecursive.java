package com.myprograms.prime_factorization_recursive;
import java.util.List;

public class PrimeFactorizationRecursive {
	public List<Integer> factorize(int n, List<Integer> listPrimeFactors) {
		if(isPrime(n)) {
			listPrimeFactors.add(n);
		}else {
			int i = 2;
			while(true) {
				if(isPrime(i) && isInteger(n/Double.valueOf(n/i))) {
					n/=i;
					listPrimeFactors.add(i);
					factorize(n, listPrimeFactors);
					break; 	
				}
				i++;
			}
		}
		return listPrimeFactors;
	}
	
	private boolean isInteger(double n) {
		if(n == (int)n)
			return true;
		else
			return false;
	}
	private boolean isPrime(int n) {
		for(int i=2; i< Math.sqrt(n); i++) {
			if(n%i == 0)
				return false;
		}
		return true;
	}
}
