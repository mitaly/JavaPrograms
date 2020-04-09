package com.myprograms.ctci.strings;

public class OneAway {
	public static void main(String[] args) {
		String[][] pairs = {{"pale", "ple"},
				{"pales", "pale"},
				{"pale", "bale"},
				{"pale", "bake"}};
		for(String[] pair:pairs) {
			System.out.println(check(pair[0], pair[1]));
		}
	}
	private static boolean check(String s1, String s2) {
		if(s1.length() - s2.length() == 1) {
			return checkForUnequalLengthStrings(s1, s2);
		}else if(s1.length() - s2.length() == -1) {
			return checkForUnequalLengthStrings(s2, s1);
		}else if(s1.length() == s2.length()) {
			return checkForEqualLengthStrings(s1, s2);
		}
		return false;
	}
	private static boolean checkForUnequalLengthStrings(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int count = 0;
		for(int i = 0, j = 0; i<s1.length() && j<s2.length(); ) {
			if(c1[i] != c2[j]) {
				if(count == 1) {
					return false;
				}
				i++;
				count++;
			}else {
				i++;
				j++;
			}
		}
		return true;
	}
	private static boolean checkForEqualLengthStrings(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int count = 0;
		for(int i = 0; i<s1.length(); i++) {
			if(c1[i] != c2[i]) {
				if(count == 1)
					return false;
				count++;
			}
		}
		return true;
	}
}
