package com.myprograms.ctci.strings;

public class CheckPalindromePermutation {
	public static void main(String[] args) {
		String s = "Rats live on no evil star";
		System.out.println(check(s));
	}

	public static boolean check(String str) {
		int[] ca = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

		for (char cc : str.toCharArray()) {
			int numericVal = Character.getNumericValue(cc);
			if (numericVal > 0)
				ca[numericVal - Character.getNumericValue('a')] += 1;
		}
		// a palindrome can contain only single char having odd number of occurences. 
		// rest all should have even number of occurences 
		boolean odd = false;
		for (int x : ca) {
			if (x % 2 == 1) {
				if (odd)
					return false;
				odd = true;
			}
		}
		return true;
	}
}
