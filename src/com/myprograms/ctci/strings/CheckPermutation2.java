package com.myprograms.ctci.strings;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation2 {
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		
		for(String[] pair : pairs) {
			System.out.println(check2(pair[0], pair[1]));
		}
	}
	
	private static boolean check1(String s1, String s2) {
		Map<Character, Integer>  m = new HashMap<Character, Integer>();
		for(char c1:s1.toCharArray()) {
			m.put(c1, m.getOrDefault(c1, 0)+1);
		}
		for(char c2:s2.toCharArray()) {
			Integer val = m.get(c2);
			if(val == null || val == 0) {
				return false;
			}
			if(val == 1) {
				m.remove(c2);
			}else {
				m.put(c2, val -1);	
			}
		}
		if(m.isEmpty()) {
			return true;
		}
		return false;
	}
	private static boolean check2(String s1, String s2) {
		int[] ca = new int[128];
		for(char c1:s1.toCharArray())
			ca[c1] += 1;
		for(char c2:s2.toCharArray()) {
			ca[c2] -= 1;
			if(ca[c2] < 0)
				return false;
		}
		return true;
	}
}
