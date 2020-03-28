package com.myprograms.arrayrotations;

public class MoveAllzeroesToLeft {
	public static void move(int[] a) {
		for(int i = 0; i<a.length-1; i++) {
			
			int j = i+1;
			for(; j<a.length; j++) {
				if(a[j] == 0) {
					for(int k = j-1; k>=i; k--) {
						a[k+1] = a[k];
					}
					a[i] = 0;
					break;
				}
			}
		}
		for(int x:a) {
			System.out.println(x);
		}
	}
	
	public static void move1(int[] a) {
		int j = a.length-1;
		for(int i = a.length-1; i>=0; i--) {
			if(a[i] != 0) {
				a[j--] = a[i];
			}
		}
		while(j >= 0)
			a[j--] = 0;
		
		for(int x:a) {
			System.out.println(x);
		}
	}
}
