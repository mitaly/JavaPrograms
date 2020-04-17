package com.myprograms.ctci.chap1strings;

import java.util.HashSet;
import java.util.Set;

public class StringRotation {
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"},
				{"walterwhite", "erwhitewalt"}};
		for(String[] pair : pairs) {
			System.out.println(isRotated1(pair[0], pair[1]));	
		}
	}
	//concatenate s1 and s1. if s2 is substring of the concatenation, then it is rotated form
	private static boolean isRotated1(String s1, String s2) {
		String temp = s1+s1;
		if(temp.indexOf(s2) >= 0)
			return true;
		return false;
	}
	
	private static boolean isRotated(String s1, String s2) {
		char firstChar = s1.charAt(0);
		Set<Integer> indices = new HashSet<Integer>();
		for(int i = 0; i<s2.length(); i++) {
			if(s2.charAt(i) == firstChar) {
				indices.add(i);
			}
		}
		
		for(int index : indices) {
			int i = 0;
			for(int j = index; i<s1.length(); i++) {
				if(s1.charAt(i) != s2.charAt(j)) 
					break;
				j = (j+1)%s2.length();
			}
			if(i == s1.length())
				return true;
		}
		return false;
	}
}
