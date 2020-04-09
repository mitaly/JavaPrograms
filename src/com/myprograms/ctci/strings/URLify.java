package com.myprograms.ctci.strings;

public class URLify {
	public static void main(String[] args) {
		String str = "Mr John Smith    ";
		System.out.println(url(str, 13));
		System.out.println(str);
		System.out.println(urlEffec(str, 13));
	}
	public static String url(String s, int trueLength) {
		char[] ca = s.toCharArray();
		int j = ca.length-3;
		for(int i = 0; i<ca.length;) {
			if(ca[i] == ' ') {
				for(; j>i; j--) {
					ca[j+2] = ca[j]; 
				}
				j = ca.length - 3;
				ca[i] = '%';
				ca[i+1] = '2';
				ca[i+2] = '0';
				
				i += 3;
			}else {
				i += 1;
			}
		}
		return String.valueOf(ca);
	}
	/**
	 * Effective algo
	 * @param s
	 * @param trueLength
	 * @return
	 */
	public static String urlEffec(String s, int trueLength) {
		char[] ca = s.toCharArray();
		int diff = s.length() - trueLength;
		for(int i = trueLength-1; i >= 0; i--) {
			if(ca[i] == ' ') {
				int j = i+diff;
				ca[j] = '0';
				ca[j-1] = '2';
				ca[j-2] = '%';
				diff -= 2;
			}else {
				ca[i+diff] = ca[i];
			}
		}
		return String.valueOf(ca);
	}
}
