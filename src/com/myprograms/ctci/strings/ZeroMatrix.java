package com.myprograms.ctci.strings;

public class ZeroMatrix {
	public static void main(String[] args) {
		int[][] a = {{1,2,0,4}, {5,6,7,8}, {9,0,11,12}, {13,14,15,16}};
		printMatrix(a);
		set2(a);
		printMatrix(a);
	}
	
	private static void printMatrix(int[][] a) {
		for(int i = 0; i<a.length; i++) {
			for(int j = 0; j<a[i].length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	/**
	 * storing the rows and columns which have to set as zero. at the ending, setting them zero
	 * @param a
	 */
	private static void set1(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		boolean[] rows = new boolean[m];
		boolean[] cols = new boolean[n];
		
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				if(a[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		
		// set the rows as zero
		for(int i = 0; i<rows.length; i++) {
			if(rows[i]) {			
				for(int c = 0; c<n; c++) {
					a[i][c] = 0;
				}
			}
		}
		
		//set the columns as zero
		for(int i = 0; i<cols.length; i++) {
			if(cols[i]) {
				for(int r = 0; r<m; r++) {
					a[r][i] = 0;
				}
			}
		}
	}
	/**
	 * setting the row and col as -1. the set as 0 at the end
	 * @param a
	 */
	private static void set(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				if(a[i][j] == 0) {
					//set col
					for(int r = i-1; r>=0; r--)
						a[r][j] = -1;
					for(int r = i+1; r<m; r++)
						a[r][j] = -1;
					//set row
					for(int c = j-1; c>=0; c--)
						a[i][c] = -1;
					for(int c = j+1; c<n; c++)
						a[i][c] = -1;
				}
			}
		}
		
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				if(a[i][j] == -1)
					a[i][j] = 0;
			} 
		}
	}
	
	private static void set2(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		
		boolean rowHasZero = false;
		boolean colHasZero = false;
		
		// find if 0th column has any 0
		for(int i = 0; i<m; i++) {
			if(a[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}
		
		//find if 0th row has any 0
		for(int j = 0; j<n; j++) {
			if(a[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}
		
		//setting the element as 0 in row 0 and col 0 for particular index having 0.
		for(int i = 1; i<m; i++) {
			for(int j = 1; j<n; j++) {
				if(a[i][j] == 0) {
					a[0][j] = 0;
					a[i][0] = 0;
				} 
			}
		}
		
		
		//setting the row as zero where 0th column is having 0
		for(int i = 0; i<m; i++) {
			if(a[i][0] == 0) {
				for(int c = 0; c<n; c++) {
					a[i][c] = 0;
				}
			}
		}
		
		//setting the col as zero where 0th row is having 0
		for(int j = 0; j<n; j++) {
			if(a[0][j] == 0) {
				for(int r = 0; r<m; r++) {
					a[r][j] = 0;
				}
			}
		}
		
		if(rowHasZero) {
			for(int j = 0; j<n; j++) {
				a[0][j] = 0;
			}
		}
		
		if(colHasZero) {
			for(int i = 0; i<m; i++) {
				a[i][0] = 0;
			}
		}
	}
}
