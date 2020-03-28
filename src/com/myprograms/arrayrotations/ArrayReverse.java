package com.myprograms.arrayrotations;

public class ArrayReverse {
	int a;
	String b;
	public static void reverse(int[] a) {
		int i = 0, j = a.length-1;
		while(i < j) {
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
			i++; j--;
		}
		for(int x: a)
			System.out.println(x);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArrayReverse other = (ArrayReverse) obj;
		if (a != other.a)
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		return true;
	}
	
}
