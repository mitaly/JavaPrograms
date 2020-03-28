package com.myprograms.string;

public class ReverseString {
	public static void reverse(String str) {
		char[] val = str.toCharArray();
		for(int i = 0, j = val.length-1; i < j; i++, j--) {
			char temp = val[i];
			val[i] = val[j];
			val[j] = temp;
		}
		str = String.valueOf(val);
		System.out.println(str);
	}
	
	public static void reverse1(String a) {
		StringBuilder sb = new StringBuilder(a);
		a = sb.reverse().toString();
		System.out.println(a);
	}
	
	public static void reverse2(String a) {
		byte[] bb = a.getBytes();
		byte[] res = new byte[bb.length];
		for(int i = bb.length-1; i>=0; i--) {
			res[bb.length-1-i] = bb[i];
		}
		System.out.println(new String(res));
	}
}
