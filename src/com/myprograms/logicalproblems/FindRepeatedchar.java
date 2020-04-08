package com.myprograms.logicalproblems;

//find first repeated character
public class FindRepeatedchar {
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		
		char[] count = new char[256];
		for(char c: s.toCharArray()) {
			if(count[c] != '\0') {
				System.out.println(c);
				return;
			}
			count[c] = c;
		}
	}
}
