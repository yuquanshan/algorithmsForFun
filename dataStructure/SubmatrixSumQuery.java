/**
* given a 2D matrix, find the sum of the elements inside 
* the rectangle defined by its upper left corner (row1, col1) 
* and lower right corner (row2, col2).
* should support repeated query.
* 	public class SubmatrixSumQuery {
*    	public SubmatrixSumQuery(int[][] matrix){}
*    	public void update(int row, int col, int val){}
*    	public int sumRegion(int row1, int col1, int row2, int col2){}
*	} 
* (segment tree TLE for the first time)
*/
import java.util.*;

public class SubmatrixSumQuery{	// a binary indexed tree approach
	int[][] bitmatrix;
	int[][] origin;
	boolean good;
	public SubmatrixSumQuery(int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			good = false;
		else
			good = true;
		if(good){
			bitmatrix = new int[matrix.length+1][matrix[0].length+1];
			origin = new int[matrix.length][matrix[0].length];
			for(int i = 0; i<matrix.length; i++){
				for(int j = 0; j<matrix[0].length; j++){
					update(i,j,matrix[i][j]);
				}
			}
			origin = matrix;
			for(int[] a: bitmatrix)
				System.out.println(Arrays.toString(a));
		}else{
			bitmatrix = null;
			origin = null;
		}
	}

 	public void update(int row, int col, int val){
 		if(good){
	 		int x = row+1;
	 		int change = val - origin[row][col];
	 		origin[row][col] = val;
	 		while(x<=origin.length){
	 			updateRow(x,col+1,change);
	 			x += (x & (-x));
	 		}
 		}
 	}
 	private void updateRow(int x, int y, int change){
 		while(y<=origin[0].length){
 			bitmatrix[x][y] += change;
 			y += (y & (-y));
 		}
 	}
 	public int sumRegion(int row1, int col1, int row2, int col2){
 		if(good){
	 		int sum1 = sumLeftTop(row2+1, col2+1);
	 		int sum2 = sumLeftTop(row1,col2+1);
	 		int sum3 = sumLeftTop(row2+1, col1);
	 		int sum4 = sumLeftTop(row1, col1);
	 		return sum1 - sum2 - sum3 + sum4;
 		}else
 			return 0;
 	}
 	private int sumLeftTop(int x, int y){
 		int sum = 0;
 		while(x > 0){
 			sum += sumRow(x, y);
 			x -= (x & (-x));
 		}
 		return sum;
 	}
 	private int sumRow(int x, int y){
 		int sum = 0;
 		while(y>0){
 			sum += bitmatrix[x][y];
 			y -= (y & (-y));
 		}
 		return sum;
 	}
 	public static void main(String[] args) {
 		//int[][] matrix = {{0,3,4,8,7},{3,2,1,0,3},{5,9,6,7,0}};
 		int[][] matrix = {};
 		SubmatrixSumQuery query = new SubmatrixSumQuery(matrix);
 		System.out.println(query.sumRegion(1,1,2,2));
 		query.update(1,2,3);
 		System.out.println(query.sumRegion(1,1,2,2));
 	}
}