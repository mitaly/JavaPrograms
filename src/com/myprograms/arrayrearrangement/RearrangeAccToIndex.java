package com.myprograms.arrayrearrangement;

public class RearrangeAccToIndex {
	public Integer[] rearrangeArrayAccToIndex(Integer[] arr) {
		Integer[] resultArr = new Integer[arr.length];
		for(int i = 0; i < arr.length; i++) {
			if(searchElement(arr, i))
				resultArr[i] = i;	
			else
				resultArr[i] = -1;
		}
		return resultArr;
	}
	private boolean searchElement(Integer[] arr, int element) {
		int li = 0, ri = arr.length-1;
		while(li <= ri) {
			int mid = (li+ri)/2;
			if(arr[mid] == element)
				return true;
			else if(arr[mid] < element)
				li = mid+1;
			else
				ri = mid-1;
		}
		return false;
	}
	
	public void rearrange(Integer[] A) {
		for (int i = 0; i < A.length; i++){ 
            if (A[i] != -1 && A[i] != i){ 
                int x = A[i]; 
                while (A[x] != -1 && A[x] != x)  { 
                    int y = A[x];  
                    A[x] = x; 
                    x = y; 
                } 
                A[x] = x;  
                if (A[i] != i) { 
                    A[i] = -1; 
                } 
            } 
        } 
	}
}
