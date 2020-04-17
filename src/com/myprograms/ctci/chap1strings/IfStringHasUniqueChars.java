package com.myprograms.ctci.chap1strings;

public class IfStringHasUniqueChars {
	public static void main(String[] args) {
		String str = "geks";
		int check = 0;
		for(char c : str.toCharArray()) {
			int val = c - 'a';
			if((check & (1 << val)) > 0) {
				System.out.println(false);
				return;
			}
			check |= (1 << val);
		}
		System.out.println(true);
	}
}
