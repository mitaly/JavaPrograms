package com.myprograms.ctci.chap1strings;

public class StringCompression {
	public static void main(String[] args) {
		String s = "aabcccccaaa";
		System.out.println(compress(s));
	}
	private static String compress(String s) {
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i<s.length();) {
			int count = 1;
			char c = s.charAt(i);
			i++;
			while(i< s.length() && s.charAt(i) == c) {
				i++;
				count++;
			}
			builder.append(String.valueOf(c))
			.append(count);
		}
		String formedString = builder.toString();
		if(formedString.length() >= s.length())
			return s;
		return formedString;
	}
}
