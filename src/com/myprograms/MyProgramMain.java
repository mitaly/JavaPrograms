package com.myprograms;

import java.util.ArrayList;
import java.util.List;

import com.myprograms.arrayrotation.ArrayRotation;
import com.myprograms.factorial.Factorial;
import com.myprograms.find_maximum_sum.FindMaximumSum;
import com.myprograms.find_pair_having_sum.FindingPair;
import com.myprograms.find_pair_having_sum.FindingPairRotated;
import com.myprograms.gcd.GCD;
import com.myprograms.prime_factorization_recursive.PrimeFactorizationRecursive;
import com.myprograms.search_in_rotated_array.SearchInRotated;
import com.myprograms.tailrecursionfactorial.TailRecursionFactorial;

public class MyProgramMain {
	public static void main(String[] args) {
//		Factorial factorial = new Factorial();
//		System.out.println(factorial.factorial(5));
	
//		TailRecursionFactorial factorial = new TailRecursionFactorial();
//		System.out.println(factorial.factorial(25, 1));
		
//		PrimeFactorizationRecursive factorization = new PrimeFactorizationRecursive();
//		List<Integer> listPrimeFactors = new ArrayList<>();
//		System.out.println(factorization.factorize(315, listPrimeFactors));
		
//		ArrayRotation rotation = new ArrayRotation();
//		Integer[] arr = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12};
//		arr = rotation.rotateRight(arr, 2);
//		arr = rotation.rotateLeftUsingTempArray(arr, 2);
//		arr = rotation.rotateLeftOneByOneStep(arr, 7);
//		arr = rotation.rotateJugglingAlgo(arr, 3);
//		arr = rotation.rotateReversalAlgo(arr, 7);
//		for (Integer i : arr) {
//			System.out.println(i);
//		}
		
//		GCD gcd = new GCD();
//		System.out.println(gcd.gcd(2,7));
//		
//		Integer[] arr = new Integer[] {-8, 1, 4, 6, 10, 45};
//		FindingPair findingPair = new FindingPair();
//		int resultArr[] = findingPair.findPairHavingSum(arr, 160);
//		if(resultArr != null)
//			for (int i : resultArr) {
//				System.out.println(i);
//			}
//		else
//			System.out.println("no such pair");
		
//		Integer[] arr = new Integer[] {23,46,878,900, 12,15,18,20};
//		SearchInRotated search = new SearchInRotated();
//		System.out.println(search.searchInRotatedArray(arr, 12));
		
//		Integer[] arr = new Integer[] {4,5,6,7,-1,1,2};
//		FindingPairRotated pairRotated = new FindingPairRotated();
//		int[] resultArr = pairRotated.findingPairRotatedArray(arr, 7);
//		if(resultArr != null)
//			for(int i : resultArr)
//				System.out.println(i);
//		else
//			System.out.println("no such pair");
		
		Integer[] arr = new Integer[] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		FindMaximumSum maximumSum = new FindMaximumSum();
		System.out.println(maximumSum.findMaximumValueOfSum(arr));
	}
}
