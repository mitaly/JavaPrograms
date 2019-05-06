package com.myprograms;

import java.util.Arrays;
import java.util.List;

import com.myprograms.gp.CountTriplets;
import com.myprograms.graphs.DFSGraph;
import com.myprograms.linkedlist.LinkedListOperations;

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
//		arr = rotation.rotateLeftReversalAlgo(arr, 7);
//		arr = rotation.rotateRightReversalAlgorithm(arr, 3);
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
		
//		Integer[] arr = new Integer[] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//		FindMaximumSum maximumSum = new FindMaximumSum();
//		System.out.println(maximumSum.findMaximumValueOfSum(arr));
		
//		Integer arr[] = new Integer[] {1, 2, 3, 4, 5, -6};
//		MinimumElementInRotated minimumElement = new MinimumElementInRotated();
//		System.out.println(minimumElement.findMinimumElementInRotatedArray(arr));
		
//		Integer arr[] = new Integer[] {2,4,8,0,4,45};
//		HammingDistance hammingDistance = new HammingDistance();
//		hammingDistance.findArrayHavingMaximumHammingDistance(arr);
//		for(int i : arr) {
//			System.out.print(i+" ");
//		}
		
//		Integer[] arr = new Integer[] {1, 3, 5, 7, 9};
//		PrintLeftRotatedArray print = new PrintLeftRotatedArray();
//		print.printAndRotateLeft(arr, 1);
		
//		Integer[] arr = new Integer[] {1, 2, 3, 4, 5};
//		Integer[][] rotationsArr = new Integer[][] {{0,2},{2,4}};
//		ElementAtIndexAfterRotation find = new ElementAtIndexAfterRotation();
//		System.out.println(find.findElementAtGivenIndex(arr, rotationsArr, 4));
		
//		Integer[] arr = new Integer[] {12,10,34,455,566};
//		SplitAndAddToEnd splitAndAdd = new SplitAndAddToEnd();
////		splitAndAdd.splitAndAddArrayToEnd(arr, 4);
//		splitAndAdd.splitAndAddUsingRotation(arr, 0);
//		for(int i : arr)
//			System.out.print(i+" ");
	
		/* Rearrangement problems array*/
//		Integer[] arr = new Integer[] {19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
//	              11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
//		RearrangeAccToIndex indexRearrange = new RearrangeAccToIndex();
////		Integer[] resultArr = indexRearrange.rearrangeArrayAccToIndex(arr);
////		for(int i : resultArr)
////			System.out.print(i+" ");
//		indexRearrange.rearrange(arr);
//		for(int i : arr)
//			System.out.print(i+" ");
		
		//Reverse an array
//		Integer[] arr = new Integer[] {23,3,4,56,67,89};
//		ReverseArray reverse = new ReverseArray();
//		reverse.reverseArray(arr);
//		for(int i : arr) System.out.print(i+" ");
//		System.out.println(reverse.reverseString("roma india"));
		
//		Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j] if i is odd and j < i
//		Integer[] arr = new Integer[] {1, 2, 1, 4, 5, 6, 8, 8};
//		RearrangeEvenAndOddIndexes rearrange = new RearrangeEvenAndOddIndexes();
//		rearrange.rearrangeEvenAndOddIndexes(arr);
		
//		Rearrange positive and negative numbers in O(n) time and O(1) extra space
//		Integer[] arr = new Integer[] {-1, -2, -3, -4, -5, 6, -7, 8 };
//		RearrangePositiveAndNegative rearrange = new RearrangePositiveAndNegative();
//		rearrange.rearrangePositiveAndNegativeNumbers(arr);
//		for(int x : arr) System.out.print(x+" ");
		
//		Rearrange array in alternating positive & negative items with O(1) extra space
//		Integer[] arr = new Integer[] {1, 2, -30, -90, -1000, 3, 6};
//		RearrangePositiveAndNegative1 rearrange = new RearrangePositiveAndNegative1();
//		rearrange.rearrangePositiveAndNegativeNumbers(arr);
//		for(int x:arr) System.out.print(x+" ");
		
//		Move all zeroes to end of array
//		Integer arr[] = new Integer[] {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
//		MoveZerosToEnd moveZeroes = new MoveZerosToEnd();
//		moveZeroes.moveZeroesToEnd(arr);
//		moveZeroes.moveZeroesToEnd1(arr);
//		moveZeroes.moveZeroesToEnd2(arr);
//		for(int x:arr) System.out.print(x+" ");
		
//		Minimum swaps required to bring all elements less than or equal to k together
//		Integer arr[] = new Integer[] {2, 7, 9, 5, 8, 7, 4};
//		int k = 10;
//		MinSwaps minSwaps = new MinSwaps();
//		System.out.println(minSwaps.minSwaps1(arr, k));
		
//		arrange them such that all negative integers appear before all the positive integers in the array without using any additional data structure like hash table, arrays, etc. 
//		The order of appearance should be maintained.
//		move zeroes(if present) between positive and negative numbers
//		Integer arr[] = new Integer[] {12,0, 11, 0, 5, 6, 7, 5, 3, 6};
//		RearrangePositiveAndNegative2 rearrange = new RearrangePositiveAndNegative2();
//		rearrange.rearrangePositiveAndNegativeNumbers(arr);
//		for(int x:arr) System.out.print(x+" ");
		
		
//		Convert the array in such a way that if next non-zero number is same as current number,
//		double its value and replace the next number with 0.
//		After the modification, rearrange the array such that all 0’s are shifted to the end.
//		Integer[] arr = new Integer[] {2, 2, 0, 4, 0, 8};
//		DoubleAndZero doubleAndZero = new DoubleAndZero();
//		doubleAndZero.doubleAndMoveZeroesToEnd(arr);
//		for(int x:arr) System.out.print(x+" ");
	
//		Given two integer arrays of same size, “arr[]” and “index[]”,
//		reorder elements in “arr[]” according to given index array
//		Integer[] arr = new Integer[] {50, 40, 70, 60, 90};
//		Integer[] index = new Integer[] {3,  0,  4,  1,  2};
//		ReorderAccToIndex reorder = new ReorderAccToIndex();
////		reorder.reorderUsingAuxiliaryArr(arr, index);
//		reorder.reorderWithoutAuxiliaryArr(arr, index);
//		for(int x:arr) System.out.print(x+" ");
		
//		Given an array of positive and negative numbers, arrange them 
//		such that all negative integers appear before all the positive integers
//		relative order should be maintained
//		Integer[] arr = new Integer[] {12, 11, -13, -5, 6, -7, 5, -3, -6};
//		RearrangePositiveAndNegative3 rearrange = new RearrangePositiveAndNegative3();
//		rearrange.rearrange(arr);
//		for(int x:arr) System.out.print(x+" ");
		
//		Rearrange an array such that ‘arr[j]’ becomes ‘i’ if ‘arr[i]’ is ‘j’ 
//		Integer[] arr = new Integer[] {2, 0, 1, 4, 5, 3};
//		RearrangeAccToIndex1 r = new RearrangeAccToIndex1();
//		r.rearrange(arr);
//		for(int x:arr) System.out.print(x+" ");
		
		//Count triplets
//		List<Long> list = Arrays.asList(1L,1L, 1L, 1L, 1L);
//		CountTriplets triplets = new CountTriplets();
//		System.out.println(triplets.countTriplets(list, 1));
		
//		LinkedListOperations op = new LinkedListOperations();
//		op.insertAtStart(23);
//		op.insertAtStart(4556);
//		op.insertAtStart(12);
//		op.insertAtEnd(90);
//		op.insertAfterData(912, 0);
//		op.insertAtEnd(7);
//		
//		op.printList();
		
		
		/* ---------------------Graph---------------------------------------*/
		//DFS
		DFSGraph graph = new DFSGraph(4, 2);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		graph.dfs();
	}
}
