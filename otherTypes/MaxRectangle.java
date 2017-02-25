/**
* Given a 2D binary matrix filled with 0's and 1's, find the largest 
* rectangle containing only 1's and return its area.
*
* For example, given the following matrix:
* 1 0 1 0 0
* 1 0 1 1 1
* 1 1 1 1 1
* 1 0 0 1 0
* Return 6.
*
* public int maximalRectangle(char[][] matrix)
*/
import java.util.*;

public class MaxRectangle {
	public int maximalRectangle(char[][] m) {
		if(m == null || m.length == 0 || m[0].length == 0) return 0;
		int[][] matrix = new int[m.length][m[0].length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(m[i][j] == '1') {
					if(i > 0) matrix[i][j] = 1 + matrix[i-1][j];
					else matrix[i][j] = 1;
				}
			}
		}
		Stack<Integer> stack = new Stack<Integer>();
		int maxSoFar = 0;
		//for(int[] row: matrix) System.out.println(Arrays.toString(row));
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				while(!stack.isEmpty() && matrix[i][stack.peek()] >= matrix[i][j]) {
					int tmp = matrix[i][stack.pop()];
					int size = 0;
					if(stack.isEmpty()) size = j*tmp;
					else size = (j - stack.peek() - 1)*tmp;
					if(size > maxSoFar) {
						maxSoFar = size;
						//System.out.format("%d - %d, %d\n", i, tmp, maxSoFar);
					}
				}
				stack.push(j);
			}
			while(!stack.isEmpty()) {
				int tmp = matrix[i][stack.pop()];
				int size = 0;
				if(stack.isEmpty()) size = matrix[0].length*tmp;
				else size = (matrix[0].length - stack.peek() - 1)*tmp;
				if(size > maxSoFar) {
					maxSoFar = size;
					//System.out.format("%d - %d, %d\n", i, tmp, maxSoFar);
				}
			}
		}
		return maxSoFar;
	}
	public static void main(String[] args) {
		//char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},
							//{'1','1','1','1','1'},{'1','0','0','1','0'}};
		//char[][] matrix = {{'0','1'},{'1','0'}};
		char[][] matrix = {{'0','1','1','0','1'},{'1','1','0','1','0'},{'0','1','1','1','0'},
							{'1','1','1','1','0'},{'1','1','1','1','1'},{'0','0','0','0','0'}};
		MaxRectangle test = new MaxRectangle();
		System.out.println(test.maximalRectangle(matrix));
	}
}