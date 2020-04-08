package com.myprograms.logicalproblems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindFirstNotRepeatingChar {
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		findFirstNonRepeatingChar(s);
		System.out.println("***********");
		findFirstNonRepeatingChar1(s);
	}
	
	static void findFirstNonRepeatingChar1(String s) {
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(char c: s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for(Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				System.out.println(entry.getKey());
			}
		}
	}
	static void findFirstNonRepeatingChar(String s) {
		int count[] = new int[256];
		for(char c: s.toCharArray()) {
			count[c]++;
		}
		
		for(int i = 0; i<count.length; i++) {
			if(count[i] == 1) {
				System.out.println(Character.toChars(i));
			}
		}
//		for(char c: s.toCharArray()) {
//			if(count[c] == 1) {
//				System.out.println(c);
//			}
//		}
	}
}
