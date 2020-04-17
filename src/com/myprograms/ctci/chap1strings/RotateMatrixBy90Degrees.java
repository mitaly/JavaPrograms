package com.myprograms.ctci.chap1strings;

public class RotateMatrixBy90Degrees {
	public static void main(String[] args) {
//		int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
//		int[][] a = {{1,2}, {4,5}};
//		int[][] a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		int[][] a = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
		for(int i = 0; i<a.length; i++) {
			for(int j = 0;j<a[i].length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		
		rotate(a);
	
		System.out.println();
		for(int i = 0; i<a.length; i++) {
			for(int j = 0;j<a[i].length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
	private static void rotate(int[][] a) {
		int N  = a.length;
		int m = N-1;
		//layers
		for(int x = 0; x<N/2; x++) {
			//traversing the layer
			for(int y = x; y<m-x; y++) {
				int t = a[x][y];
				a[x][y] = a[y][m-x];
				a[y][m-x] = a[m-x][m-y];
				a[m-x][m-y] = a[m-y][x];
				a[m-y][x] = t;
			}
		}
	}
}
